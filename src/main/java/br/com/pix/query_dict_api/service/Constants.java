package br.com.pix.query_dict_api.service;

public class Constants {
    public static final String KEY_REGEX_EVP_PATTERN = "^[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}$";
    public static final String KEY_REGEX_CPF_PATTERN = "^[0-9]{11}$";
    public static final String KEY_REGEX_CNPJ_PATTERN = "^[0-9]{14}$";
    public static final String KEY_REGEX_EMAIL_PATTERN = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
    public static final String KEY_REGEX_PHONE_PATTERN = "^\\+[1-9]\\d{1,14}$";
    public static final String INVALID_KEY_FORMAT = "Invalid key format: ";
    public static final String INVALID_KEY_TYPE_FOR_KEY = "Invalid key type for key: ";
    public static final String KEY_NOT_FOUND = "Key not found: ";
    public static final String QUERYING_ENTRIES_BY_ACCOUNT = "Querying entries by account: {}";
    public static final String QUERYING_KEY = "Querying key: {}";
}

