package net.ivanvega.miclientecpcontactosb;

import android.net.Uri;

public class ContractCPContactos {

    public static final Uri CONTENT_URI =
            Uri.parse("content://net.ivanvega.mibasedatosp77b.provider/contactos");

    public static final String FIELD_ID = "_id";
    public static final String FIELD_USUARIO = "usuario";
    public static final String FIELD_EMAIL = "email";
    public static final String FIELD_TEL = "tel";

    public static final String[] PROJECTION ={"_id ", "usuario", "email", "tel"};




}
