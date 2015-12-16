package alvaro.pm.opcionespreferencias;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;


public class Preferencias extends PreferenceActivity implements SharedPreferences.OnSharedPreferenceChangeListener {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.prefs);
        registrarPrefsInicio();
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(this);
        pref.registerOnSharedPreferenceChangeListener(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(this);
        pref.unregisterOnSharedPreferenceChangeListener(this);
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        registrarPrefs(key);
    }

    private void registrarPrefs(String key){
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(this);
        Preference connectionPref = findPreference(key);
        switch (key){
            case "email":
                connectionPref.setSummary(pref.getString(key, ""));
                break;
            case "colorFondo":
                connectionPref.setSummary(pref.getString(key, ""));
                break;
            case "colorLetra":
                connectionPref.setSummary(pref.getString(key, ""));
                break;
            case "nombre":
                connectionPref.setSummary(pref.getString(key, ""));
                break;
            case "apellidos":
                connectionPref.setSummary(pref.getString(key, ""));
                break;
        }
    }

    private void registrarPrefsInicio(){
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(this);
        Preference connectionPref = findPreference("email");
        connectionPref.setSummary(pref.getString("email", ""));
        connectionPref = findPreference("colorFondo");
        connectionPref.setSummary(pref.getString("colorFondo", ""));
        connectionPref = findPreference("colorLetra");
        connectionPref.setSummary(pref.getString("colorLetra", ""));
        connectionPref = findPreference("nombre");
        connectionPref.setSummary(pref.getString("nombre", ""));
        connectionPref = findPreference("apellidos");
        connectionPref.setSummary(pref.getString("apellidos", ""));
    }

}
