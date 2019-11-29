package io.limx.wallet.android.ui;

import android.content.Intent;
import android.os.Bundle;

import io.limx.wallet.android.Constants;

/**
 * @author John L. Jegutanis
 */
@Deprecated
public class SendActivity extends BaseWalletActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = new Intent(this, WalletActivity.class);
        intent.putExtra(Constants.ARG_URI, getIntent().getDataString());
        startActivity(intent);

        finish();
    }
}
