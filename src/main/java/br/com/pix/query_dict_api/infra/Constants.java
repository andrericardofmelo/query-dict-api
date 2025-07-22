package br.com.pix.query_dict_api.infra;

public class Constants {

    private Constants() {
        // Private constructor to prevent instantiation
    }

    public static final String KEY_REGEX_CPF_PATTERN = "^\\d{11}$";
    public static final String KEY_REGEX_CNPJ_PATTERN = "^\\d{14}$";
    public static final String KEY_REGEX_PHONE_PATTERN = "^\\+\\d{1,3}\\d{8,13}$";
    public static final String KEY_REGEX_EMAIL_PATTERN = "^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
    public static final String KEY_REGEX_EVP_PATTERN = "^[a-f0-9\\-]{36}$";
    public static final String INVALID_KEY_FORMAT = "Invalid key format: ";
    public static final String QUERYING_ENTRIES_BY_ACCOUNT = "Querying entries by account: {}";
    public static final String QUERYING_KEY = "Querying key: {}";
    public static final String ENTRIES_NOT_FOUND = "Entries not found";
}

