package com.example.emilio.Presentador.MenuPresentador;

import android.content.Context;
import android.content.Intent;

import com.example.emilio.Cuarto;
import com.example.emilio.Primero;
import com.example.emilio.Quinto;
import com.example.emilio.Segundo;
import com.example.emilio.Sexto;
import com.example.emilio.Tercero;
import com.example.emilio.Vista.LoginView.VistaLogin;

public class PresentadorMenu {
    private Context mContext;
    public PresentadorMenu(Context mContext) {
        this.mContext = mContext;
    }
    public void Direccion(int i){
        System.out.println("llego al prese");
        switch (i) {
            case 1:
        Intent intent = new Intent(mContext, Primero.class);
        mContext.startActivity(intent);
        break;
            case 2:
                Intent intent2 = new Intent(mContext, Segundo.class);
                mContext.startActivity(intent2);
                break;

            case 3:
                Intent intent3 = new Intent(mContext, Tercero.class);
                mContext.startActivity(intent3);
                break;

            case 4:
                Intent intent4 = new Intent(mContext, Cuarto.class);
                mContext.startActivity(intent4);
                break;

            case 5:
                Intent intent5 = new Intent(mContext, Quinto.class);
                mContext.startActivity(intent5);
                break;

            case 6:
                Intent intent6 = new Intent(mContext, Sexto.class);
                mContext.startActivity(intent6);
                break;

            case 7:
                Intent intent7 = new Intent(mContext, VistaLogin.class);
                mContext.startActivity(intent7);
                break;

        }
    }
}
