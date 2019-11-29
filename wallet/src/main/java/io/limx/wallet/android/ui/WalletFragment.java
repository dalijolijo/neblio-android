package io.limx.wallet.android.ui;

import android.support.v4.app.Fragment;

import io.limx.core.wallet.WalletAccount;

/**
 * @author John L. Jegutanis
 */
public abstract class WalletFragment extends Fragment implements ViewUpdateble {
    abstract public WalletAccount getAccount();
}
