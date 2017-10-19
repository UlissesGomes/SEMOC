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

public class MinicursoAdapter extends ArrayAdapter {

    private final Context context;
    private final ArrayList<Minicurso> minicursos;

    public MinicursoAdapter(@NonNull Context context, ArrayList<Minicurso> minicursos) {
        super(context, R.layout.linha_minicurso, minicursos);
        this.context = context;
        this.minicursos = minicursos;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View linha = layoutInflater.inflate(R.layout.linha_minicurso, parent, false);

        TextView txtNome = (TextView) linha.findViewById(R.id.nomeminicurso);
        TextView txtLocal = (TextView) linha.findViewById(R.id.localMinicurso);
        TextView txtData = (TextView) linha.findViewById(R.id.dataMinicurso);
        TextView txtHora = (TextView) linha.findViewById(R.id.horaMinicurso);

        txtNome.setText(minicursos.get(position).getNome());
        txtLocal.setText(minicursos.get(position).getLocal()+" - ");
        txtData.setText(minicursos.get(position).getData());
        txtHora.setText(minicursos.get(position).getHorario());

        return linha;
    }




}
