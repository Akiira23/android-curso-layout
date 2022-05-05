package br.com.alura.aluraviagens.ui.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

import br.com.alura.aluraviagens.R;
import br.com.alura.aluraviagens.model.Pacote;

public class ListaPacotesAdapter extends BaseAdapter {

    private final List<Pacote> pacotes;
    private final Context context;

    public ListaPacotesAdapter(List<Pacote> pacotes, Context context) {
        this.pacotes = pacotes;
        this.context = context;
    }

    @Override
    public int getCount() {
        return pacotes.size();
    }

    @Override
    public Object getItem(int i) {
        return pacotes.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup parent) {
        View viewCriada = LayoutInflater.from(context)
                .inflate(R.layout.item_pacote, parent, false);

        Pacote pacote = pacotes.get(i);
        TextView local = viewCriada.findViewById(R.id.item_pacote_local);
        local.setText(pacote.getLocal());

        ImageView imagem = viewCriada.findViewById(R.id.item_pacote_imagem);
        Resources resources = context.getResources();
        int idDrawable = resources.getIdentifier(pacote.getImagem(),
                "drawable", context.getPackageName());
        Drawable drawableImagemPacote = resources.getDrawable(idDrawable);
        imagem.setImageDrawable(drawableImagemPacote);

        TextView dias = viewCriada.findViewById(R.id.item_pacote_dias);
        int qtdDeDias = pacote.getDias();
        String diasEmTexto = "";

        if (qtdDeDias > 1)
            diasEmTexto = qtdDeDias + " dias";
        else
            diasEmTexto = qtdDeDias + " dia";

        dias.setText(diasEmTexto);

        TextView preco = viewCriada.findViewById(R.id.item_pacote_preco);
        NumberFormat formatoBrasileiro = DecimalFormat.getCurrencyInstance(
                new Locale("pt", "br"));
        BigDecimal precoDoPacote = pacote.getPreco();
        String moedaBrasileira = formatoBrasileiro
                .format(precoDoPacote)
                .replace("R$", "R$ ");
        preco.setText(moedaBrasileira);

        return viewCriada;
    }
}
