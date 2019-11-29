package io.limx.wallet.android.ui;

import android.os.Bundle;
import android.support.v4.preference.PreferenceFragment;

import io.limx.wallet.android.R;

/**
 * @author John L. Jegutanis
 */
public class SettingsFragment extends PreferenceFragment {
    @Override
    public void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        addPreferencesFromResource(R.xml.preferences);
    }
}
