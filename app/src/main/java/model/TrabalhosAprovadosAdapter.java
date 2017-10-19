package model;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nero.semoc.R;

import java.util.ArrayList;

/**
 * Created by Nero on 14/10/2017.
 */

public class TrabalhosAprovadosAdapter extends ArrayAdapter{

    private final Context context;
    private final ArrayList<TrabalhosAprovados> trabalhos;

    public TrabalhosAprovadosAdapter(@NonNull Context context, ArrayList<TrabalhosAprovados> trabalhos) {
        super(context, R.layout.linha_trabalho, trabalhos);
        this.context = context;
        this.trabalhos = trabalhos;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View linha = layoutInflater.inflate(R.layout.linha_trabalho, parent, false);

        TextView txtTitulo = (TextView) linha.findViewById(R.id.titulo);
        TextView txtInscricao = (TextView) linha.findViewById(R.id.inscricao);
        //ImageView img = (ImageView) linha.findViewById(R.id.imagem);


        txtTitulo.setText(trabalhos.get(position).getTitulo());
        txtInscricao.setText(trabalhos.get(position).getInscricao());

        return linha;
    }
}
