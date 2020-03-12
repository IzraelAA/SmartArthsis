package com.flege.gumukrejo.main;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.flege.gumukrejo.R;
import com.flege.gumukrejo.RiwayatTransaksiActivity;
import com.flege.gumukrejo.authentication.LoginActivity;
import com.flege.gumukrejo.session.SessionManager;
import com.google.android.material.textfield.TextInputEditText;

import java.util.Objects;

public class AkunFragment extends Fragment {
    TextInputEditText inputUserID, inputNIK, inputNama, inputNoTelp;
    LinearLayout change_password, riwayat_transaksi;
    TextView logout;
    SessionManager session;

    public AkunFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_akun, container, false);

        session =  new SessionManager(v.getContext());

        inputUserID = v.findViewById(R.id.inputUserID);
        inputNIK = v.findViewById(R.id.inputNIK);
        inputNama = v.findViewById(R.id.inputNama);
        inputNoTelp = v.findViewById(R.id.inputNoTelp);
        change_password = v.findViewById(R.id.change_password);
        riwayat_transaksi = v.findViewById(R.id.riwayat_transaksi);
        logout = v.findViewById(R.id.logout);

        inputUserID.setText(session.get_id_pelanggan());
        inputNIK.setText(session.get_nik());
        inputNama.setText(session.get_nama());
        inputNoTelp.setText(session.get_kontak());

        change_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), ChangePasswordActivity.class);
                startActivity(intent);
            }
        });

        riwayat_transaksi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), RiwayatTransaksiActivity.class);
                startActivity(intent);
            }
        });

        final DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which){
                    case DialogInterface.BUTTON_POSITIVE:
                        session.set_is_loggedout();
                        Objects.requireNonNull(getActivity()).finishAffinity();
                        break;
                    case DialogInterface.BUTTON_NEGATIVE:
                        break;
                }
            }
        };
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                builder.setMessage("Logout akun anda dari device ini?").setPositiveButton("Ya", dialogClickListener).setNegativeButton("Batal", dialogClickListener).show();
            }
        });

        return v;
    }

}
