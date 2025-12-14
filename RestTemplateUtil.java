package bdd.util;


import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.ssl.SSLContexts;
import javax.net.ssl.*;
import java.security.cert.X509Certificate;


public class RestTemplateUtil {

    public static void ignoreCertificates() {

            TrustStrategy acceptingTrustStrategy = (X509Certificate[] chain, String authType) -> true;

            try {
                SSLContext sslContext = SSLContexts.custom()
                        .loadTrustMaterial(null, acceptingTrustStrategy)
                        .build();
                HttpsURLConnection.setDefaultSSLSocketFactory(sslContext.getSocketFactory());

                // Create all-trusting host name verifier
                HostnameVerifier allHostsValid = (hostname, session) -> true;

                // Install the all-trusting host verifier
                HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid);

            } catch (Exception e) {
                throw new RuntimeException("Failed to create a trust manager that accepts all certificates", e);
            }
    }
}
