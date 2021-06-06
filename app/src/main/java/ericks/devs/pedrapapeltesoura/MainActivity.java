package ericks.devs.pedrapapeltesoura;

import androidx.appcompat.app.AppCompatActivity;

import android.icu.text.SymbolTable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void selecionadoPedra(View view){
        this.opcaoSelecionada("pedra");
    }
    public void selecionadoPapel(View view){
        this.opcaoSelecionada("papel");
    }
    public void selecionadoTesoura(View view){
        this.opcaoSelecionada("tesoura");
    }

    public void opcaoSelecionada(String escolhaUsuario){

        ImageView imageResult = findViewById(R.id.imageResult);
        TextView textResult = findViewById(R.id.textResult);

        int num = new Random().nextInt(3);
        String[] opcoes = {"pedra", "papel", "tesoura"};
        String opcaoApp = opcoes [num];

        switch (opcaoApp){
            case "pedra":
                imageResult.setImageResource(R.drawable.pedra);
                break;
            case "papel":
                imageResult.setImageResource(R.drawable.papel);
                break;
            case "tesoura":
                imageResult.setImageResource(R.drawable.tesoura);
                break;
        };

        if (
                (opcaoApp == "pedra" && escolhaUsuario == "tesoura") ||
                (opcaoApp == "tesoura" && escolhaUsuario == "papel") ||
                (opcaoApp == "papel" && escolhaUsuario == "pedra")
        ){//App ganhador
            textResult.setText("Você perdeu :( ");

        }else if (
                (escolhaUsuario == "pedra" && opcaoApp == "tesoura") ||
                (escolhaUsuario == "tesoura" && opcaoApp == "papel") ||
                (escolhaUsuario == "papel" && opcaoApp == "pedra")
        ){//User ganhador
            textResult.setText("Você ganhou :D ");
            }else{//Empate
            textResult.setText("Dessa vez foi empate ;) ");
            }

        System.out.println("Opcao clicada " + opcaoApp);
    }


}