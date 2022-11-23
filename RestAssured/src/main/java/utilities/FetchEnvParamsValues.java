package utilities;

import io.github.cdimascio.dotenv.Dotenv;

public class FetchEnvParamsValues {

    private static final Dotenv dotenv = Dotenv.load();

    public static String fetchParamValue(String param){
        return dotenv.get(param);
    }

}
