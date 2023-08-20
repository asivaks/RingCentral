package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:config/credentials.properties",  //path from source root
        //NB in Jenkins path from repository root
        "system:properties"
})

public interface RCConfig extends Config {
    @Key("webUrl")
    String webUrl();

    @Key("apiUrl")
    String apiUrl();

    @Key("selenoidLogin")
    String selenoidLogin();

    @Key("selenoidPassword")
    String selenoidPassword();

}
