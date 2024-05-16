package com.example.network_test.loaaM.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.EthernetManager;
import android.net.IpConfiguration;
import android.net.NetworkInfo;
import android.net.ProxyInfo;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiManager;

import com.example.network_test.loaaM.common.SimpleActivity;

import org.jetbrains.annotations.NotNull;

import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.List;
import java.util.Locale;

public final class NetworkUtil {
    private NetworkUtil() {}

    public final static int PREFIX_LENGTH_MAX = 32;
    public final static int TYPE_WIFI = 1;
    public final static int TYPE_MOBILE = 2;
    public final static int TYPE_ETHERNET = 3;
    public final static int TYPE_NOT_CONNECTED = 0;

    public static final int INET4ADDRESS = 41;
    public static final int INET6ADDRESS = 6;

    public static boolean isConnected(@NotNull SimpleActivity context) {
        boolean isConnect = false;
        ConnectivityManager cm = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);

        try {
            NetworkInfo networkInfo = cm.getActiveNetworkInfo();
            if (networkInfo != null) {
                if(networkInfo.getType() == ConnectivityManager.TYPE_WIFI) {
                    if(networkInfo.isConnected()) {
                        isConnect = true;
                    }
                } else if(networkInfo.getType() == ConnectivityManager.TYPE_MOBILE) {
                    if(networkInfo.isConnected()) {
                        isConnect = true;
                    }
                } else if(networkInfo.getType() == ConnectivityManager.TYPE_ETHERNET) {
                    if(networkInfo.isConnected()) {
                        isConnect = true;
                    }
                }
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }

        return isConnect;
    }

    public static int getConnectStatus(@NotNull Context context) {
        int status = TYPE_NOT_CONNECTED;
        ConnectivityManager cm = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);

        try {
            NetworkInfo networkInfo = cm.getActiveNetworkInfo();
            if (networkInfo != null) {
                if(networkInfo.getType() == ConnectivityManager.TYPE_WIFI) {
                    if(networkInfo.isConnected()) {
                        status = TYPE_WIFI;
                    }
                } else if(networkInfo.getType() == ConnectivityManager.TYPE_MOBILE) {
                    if(networkInfo.isConnected()) {
                        status = TYPE_MOBILE;
                    }
                } else if(networkInfo.getType() == ConnectivityManager.TYPE_ETHERNET) {
                    if(networkInfo.isConnected()) {
                        status = TYPE_ETHERNET;
                    }
                }
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }

        return status;
    }

    public static String getConnectStatusString(@NotNull Context context) {
        Context _context = context.getApplicationContext();
        int conn = NetworkUtil.getConnectStatus(_context);
        String status = null;

        if (conn == NetworkUtil.TYPE_WIFI) {
            status = "Wifi enabled";
        } else if (conn == NetworkUtil.TYPE_MOBILE) {
            status = "Mobile enabled";
        } else if (conn == NetworkUtil.TYPE_ETHERNET) {
            status = "Ethernet enabled";
        } else if (conn == NetworkUtil.TYPE_NOT_CONNECTED) {
            status = "No internet connection";
        }
        return status;
    }

    /**
     * get NetMask String from prefix length
     *
     * @param prefixLength prefix length integer
     * @return SubnetMask String
     */
    public static String convertPrefixLengthToNetMask(int prefixLength) {
        String result = null;

        long netMask = (-1 << (PREFIX_LENGTH_MAX - prefixLength));

        int[] addressBytes = { (int)(0xff & netMask),
                (int)(0xff & (netMask >> 8)),
                (int)(0xff & (netMask >> 16)),
                (int)(0xff & (netMask >> 24)) };

        result = String.format(Locale.getDefault(),"%d.%d.%d.%d",
                addressBytes[3], addressBytes[2], addressBytes[1], addressBytes[0]);

        return result;
    }

    /**
     * get prefix length from subnet mask
     *
     * @param netMask subnet mask String
     * @return prefix length integer
     */
    public static int convertNetMaskToPrefixLength(String netMask) {
        int result = PREFIX_LENGTH_MAX;

        String[] addressArray = netMask.split("\\.");
        long subnetMask = 0;
        if(addressArray.length == 4) {
            subnetMask += (Long.parseLong(addressArray[0]) << 24);
            subnetMask += (Long.parseLong(addressArray[1]) << 16);
            subnetMask += (Long.parseLong(addressArray[2]) << 8);
            subnetMask += (Long.parseLong(addressArray[3]));

            result = Long.toBinaryString(subnetMask).lastIndexOf('1') + 1;
        }

        return result;
    }

    /**
     * get Proxy Information
     * @param context context
     * @return ProxyInfo
     */
    public static ProxyInfo getProxyInfo(@NotNull Context context) {
        Context _context = context.getApplicationContext();
        ProxyInfo proxyInfo = null;

        int type = getConnectStatus(context);

        if(type == TYPE_WIFI) {
            WifiManager wifiManager = (WifiManager)_context.getSystemService(Context.WIFI_SERVICE);
            if(wifiManager == null)
                return null;

            List<WifiConfiguration> configList = wifiManager.getConfiguredNetworks();

            int networkId = wifiManager.getConnectionInfo().getNetworkId();
            WifiConfiguration wifiConfiguration = null;
            for (WifiConfiguration wifiConfig : configList) {
                if (networkId == wifiConfig.networkId) {
                    wifiConfiguration = wifiConfig;
                    break;
                }
            }

            if (wifiConfiguration != null) {
                proxyInfo = wifiConfiguration.getHttpProxy();
            }
        }
        else if(type == TYPE_ETHERNET) {
            EthernetManager ethernetManager = (EthernetManager)context.getSystemService(Context.ETHERNET_SERVICE);
            if(ethernetManager == null)
                return null;

            IpConfiguration ipConfiguration = ethernetManager.getConfiguration();

            if(ipConfiguration != null) {
                proxyInfo = ipConfiguration.getHttpProxy();
            }
        }

        return proxyInfo;
    }

    /**
     * get Proxy host name
     * @param context context
     * @return host name
     */
    public static String getProxyHostname(@NotNull Context context) {
        Context _context = context.getApplicationContext();
        String hostname = null;

        ProxyInfo proxyInfo = getProxyInfo(_context);
        if(proxyInfo != null) {
            hostname = proxyInfo.getHost();
        }

        return hostname;
    }

    /**
     * get Proxy port
     * @param context context
     * @return port
     */
    public static int getProxyPort(@NotNull Context context) {
        Context _context = context.getApplicationContext();
        int port = 0;

        ProxyInfo proxyInfo = getProxyInfo(_context);
        if(proxyInfo != null) {
            port = proxyInfo.getPort();
        }

        return port;
    }

    /**
     * get Proxy user name for Authenticate Server
     * @param context context
     * @return user name
     */
    public static String getProxyUsername(@NotNull Context context) {
        Context _context = context.getApplicationContext();
        String username = null;

        boolean bAuthServer = ConfigPrefs.getProxyAuthenticateServer(_context);
        if(bAuthServer) {
            String proxySSID = ConfigPrefs.getProxyAuthenticateServerSSID(_context);
//            LogUtil.d(LogUtil.DEBUG_LEVEL_1, "proxySSID = " + proxySSID);
            int type = getConnectStatus(_context);

            if (type == TYPE_WIFI) {
                WifiManager wifiManager = (WifiManager)_context.getSystemService(Context.WIFI_SERVICE);
                if(wifiManager == null)
                    return null;

                String ssId = wifiManager.getConnectionInfo().getSSID();
                ssId = ssId.replaceAll("\"", "");
//                LogUtil.d(LogUtil.DEBUG_LEVEL_1, "wifi ssId = " + ssId);
                if(proxySSID.equals(ssId)) {
                    username = ConfigPrefs.getProxyAuthenticateServerUsername(context);
                }
            } else if(type == TYPE_ETHERNET) {
                // Ethernet Proxy 설정은 serial number 값으로 대신 함.
                String serialNumber = ConfigPrefs.getSerialNumber(_context);
//                LogUtil.d(LogUtil.DEBUG_LEVEL_1, "serialNumber = " + serialNumber);
                if(proxySSID.equals(serialNumber)) {
                    username = ConfigPrefs.getProxyAuthenticateServerUsername(_context);
                }
            }
        }

        return username;
    }

    /**
     * get Proxy password for Authenticate Server
     * @param context context
     * @return password
     */
    public static String getProxyPassword(Context context) {
        Context _context = context.getApplicationContext();
        String password = null;

        boolean bAuthServer = ConfigPrefs.getProxyAuthenticateServer(_context);
        if(bAuthServer) {
            String proxySSID = ConfigPrefs.getProxyAuthenticateServerSSID(_context);
//            LogUtil.d(LogUtil.DEBUG_LEVEL_1, "proxySSID = " + proxySSID);
            int type = getConnectStatus(_context);

            if (type == TYPE_WIFI) {
                WifiManager wifiManager = (WifiManager)_context.getSystemService(Context.WIFI_SERVICE);
                if(wifiManager == null)
                    return null;

                String ssId = wifiManager.getConnectionInfo().getSSID();
                ssId = ssId.replaceAll("\"", "");
//                LogUtil.d(LogUtil.DEBUG_LEVEL_1, "wifi ssId = " + ssId);
                if(proxySSID.equals(ssId)) {
                    password = ConfigPrefs.getProxyAuthenticateServerPassword(_context);
                }
            } else if(type == TYPE_ETHERNET) {
                // Ethernet Proxy 설정은 serial number 값으로 대신 함.
                String serialNumber = ConfigPrefs.getSerialNumber(_context);
//                LogUtil.d(LogUtil.DEBUG_LEVEL_1, "serialNumber = " + serialNumber);
                if(proxySSID.equals(serialNumber)) {
                    password = ConfigPrefs.getProxyAuthenticateServerPassword(_context);
                }
            }
        }

        return password;
    }

    /**
     * Get Local IP Address
     * @param type
     * @return ip
     */
    public static String getLocalIpAddress(int type) {
        String ipAddress = "";

        try {
            for (Enumeration en = NetworkInterface.getNetworkInterfaces(); en.hasMoreElements();){
                NetworkInterface intf = (NetworkInterface) en.nextElement();

                for(Enumeration enumIpAddr = intf.getInetAddresses(); enumIpAddr.hasMoreElements();) {
                    InetAddress inetAddress = (InetAddress) enumIpAddr.nextElement();
                    if(!inetAddress.isLoopbackAddress()) {
                        switch(type){
                            case INET4ADDRESS:
                                if(inetAddress instanceof Inet4Address){
                                    ipAddress = inetAddress.getHostAddress().toString();
                                    return ipAddress;
                                }
                                break;
                            case INET6ADDRESS:
                                if(inetAddress instanceof Inet6Address){
                                    ipAddress = inetAddress.getHostAddress().toString();
                                    return ipAddress;
                                }
                                break;
                        }
                    }
                }
            }
        } catch (SocketException e) {
            e.printStackTrace();
        }

        return ipAddress;
    }

    public static String getMacAddress() {
        try {
            for (Enumeration en = NetworkInterface.getNetworkInterfaces(); en.hasMoreElements();){
                NetworkInterface intf = (NetworkInterface) en.nextElement();

//                LogUtil.d(LogUtil.DEBUG_LEVEL_1, "GET NAME = " + intf.getName());
                if (!intf.getName().equalsIgnoreCase("eth0")) continue;

                byte[] macBytes = intf.getHardwareAddress();
                if (macBytes == null) {
                    return "";
                }

                StringBuilder macAddress = new StringBuilder();
                for (byte b : macBytes) {
                    macAddress.append(String.format("%02X:",b));
                }

                if (macAddress.length() > 0) {
                    macAddress.deleteCharAt(macAddress.length() - 1);
                }

                return macAddress.toString();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "";
    }




}
