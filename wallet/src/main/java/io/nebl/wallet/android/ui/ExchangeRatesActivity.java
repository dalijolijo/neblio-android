package io.nebl.wallet.android.ui;

import android.os.Bundle;
import android.support.v7.app.ActionBar;

import io.nebl.wallet.android.R;

/**
 * @author John L. Jegutanis
 */
public class ExchangeRatesActivity extends BaseWalletActivity {
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_wrapper);

        if (savedInstanceState == null) {
            ExchangeRatesFragment fragment = new ExchangeRatesFragment();
            fragment.setArguments(getIntent().getExtras());
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, fragment)
                    .commit();
        }

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowHomeEnabled(false);
        }
    }
}
