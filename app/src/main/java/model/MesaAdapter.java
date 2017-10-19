package model;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.nero.semoc.R;

import java.util.ArrayList;

/**
 * Created by Nero on 16/10/2017.
 */

public class MesaAdapter extends ArrayAdapter {

    private final ArrayList<Mesa> mesas;
    private final Context context;

    public MesaAdapter(@NonNull Context context, ArrayList<Mesa> mesas) {
        super(context, R.layout.linha_mesa, mesas);
        this.context = context;
        this.mesas = mesas;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View linha = layoutInflater.inflate(R.layout.linha_mesa, parent, false);

        TextView txtNome = (TextView) linha.findViewById(R.id.nomeMesa);
        TextView txtLocal = (TextView) linha.findViewById(R.id.localMesa);
        TextView txtData = (TextView) linha.findViewById(R.id.dataMesa);
        TextView txtHorario = (TextView) linha.findViewById(R.id.horaMesa);

        txtNome.setText(mesas.get(position).getNomeMesa());
        txtLocal.setText(mesas.get(position).getLocal());
        txtData.setText(mesas.get(position).getData());
        txtHorario.setText(mesas.get(position).getHorario());
        return linha;
    }
}
