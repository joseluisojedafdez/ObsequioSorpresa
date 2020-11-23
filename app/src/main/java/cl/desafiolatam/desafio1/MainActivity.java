package cl.desafiolatam.desafio1;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    /* TODO
    [X] 1. Descargar el proyecto y probar que funcione corriendo en el emulador.
    [X]2. Configurar el proyecto agregando Butterknife versión 10.1.0 como dependencia.
    [x ]3. Declarar las vistas con usando anotación @BindView .
    [x ]4. Enlazar las vistas usando ButterKnife.bind()
    [x ]5. Implementar la lista con los obsequios en la actividad principal que serán utilizados en iv_result.
    [ x]6. Implementar un método que haga la entrega de 1 obsequio aleatorio de la lista de obsequios .
    [x ]7. Responder al evento @onClick entregando un obsequio usando el método definido
    anteriormente .
    [x]8. Agregar al menos 3 nuevos obsequios a la lista disponible. Estos obsequios no están incluídos
    en el proyecto y deben ser agregados usando Vector Asset, desde la galería o descargando
    imágenes desde algún sitio como flaticon.es .
    [X] 9. Volver a jugar, agregando un botón debajo de la imagen de resultado que permita reiniciar el
    juego usando el vector drawable/ic_replay.xml incluído en el proyecto.
    [x] 10. Extra. Cambiar el texto del encabezado según si el premio fue entregado o no. Por ejemplo,
    cambiar “Tenemos una sorpresa para ti” por “Felicidades! ganaste un trozo de pizza!” cuando se
    entregue pizza de obsequio. Y volver al mensaje original cuando se reinicie el juego.

     */

    private ImageView imgLeft;
    private ImageView imgRight;
    private ImageView imgCenter;
    private ImageView imgResult;
    private ImageButton replay;
    private TextView tvIntro;
    private TextView tvTitle;
    private Obsequio obsequio;
    private List<Obsequio> listaObsequios=new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgLeft = findViewById(R.id.imageViewLeft);
        imgRight = findViewById(R.id.imageViewRight);
        imgCenter = findViewById(R.id.imageViewCenter);
        imgResult = findViewById(R.id.imageViewResult);
        replay=findViewById(R.id.imgbt_replay);
        tvIntro=findViewById(R.id.tv_intro);
        tvTitle=findViewById(R.id.tv_Title);

        imgRight.setOnClickListener(mResultListener);
        imgLeft.setOnClickListener(mResultListener);
        imgCenter.setOnClickListener(mResultListener);
        replay.setOnClickListener(mReplay);

    }

    private View.OnClickListener mResultListener = new View.OnClickListener() {
        public void onClick(View v) {
            mostrarResultado();

        }
    };

    private View.OnClickListener mReplay = new View.OnClickListener() {
        public void onClick(View v) {

            reiniciarJuego();

        }
    };

    public void reiniciarJuego(){
        imgResult.setVisibility(View.INVISIBLE);
        imgLeft.setVisibility(View.VISIBLE);
        imgCenter.setVisibility(View.VISIBLE);
        imgRight.setVisibility(View.VISIBLE);
        tvTitle.setVisibility(View.VISIBLE);
        replay.setVisibility(View.INVISIBLE);
        tvIntro.setText("Elige una de estas 3 cajas sorpresa y recibe un obsequio");
    }


    public void mostrarResultado() {
            obsequio = obtenerObsequio();
            imgResult.setImageResource(obsequio.getImagen());
            imgResult.setVisibility(View.VISIBLE);
            imgLeft.setVisibility(View.INVISIBLE);
            imgCenter.setVisibility(View.INVISIBLE);
            imgRight.setVisibility(View.INVISIBLE);
            replay.setVisibility(View.VISIBLE);
            tvTitle.setVisibility(View.INVISIBLE);
            tvIntro.setText("¡¡¡Felicitaciones!!!, has ganado: "+ obsequio.getNombre());

        }

        public Obsequio obtenerObsequio() {

            listaObsequios = crearListaObsequios();
            Obsequio resultado;

            Collections.shuffle(listaObsequios);
            resultado = listaObsequios.get(0);

            return resultado;
        }

        public List<Obsequio> crearListaObsequios() {

            listaObsequios.add(new Obsequio("Pizza", R.drawable.ic_gift_pizza));
            listaObsequios.add(new Obsequio("Beach", R.drawable.ic_gift_beach));
            listaObsequios.add(new Obsequio("Music", R.drawable.ic_gift_music));
            listaObsequios.add(new Obsequio("Publica tu propio libro", R.drawable.ic_book));
            listaObsequios.add(new Obsequio("Cerveza con amigos", R.drawable.ic_cerveza));
            listaObsequios.add(new Obsequio("Viaje en tiempos de Covid", R.drawable.ic_de_viaje));

            return listaObsequios;


        }


}
