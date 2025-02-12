package gonzalez.jesus.thecheezery

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ProductosActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_productos)

        var listview: ListView = findViewById(R.id.litview) as ListView
        var imageView: ImageView = findViewById(R.id.banner) as ImageView

        val category = intent.getStringExtra("categoria")

        val productos: ArrayList<Product>
        val imagenResId: Int

        when (category) {
            "coldDrinks" -> {
                productos = agregarColdDrinks()
                imagenResId = R.drawable.colddrinks
            }
            "hotDrinks" -> {
                productos = agregarHotDrinks()
                imagenResId = R.drawable.hotdrinks
            }
            "sweets" -> {
                productos = agregarSweets()
                imagenResId = R.drawable.sweets
            }
            "salties" -> {
                productos = agregarSalties()
                imagenResId = R.drawable.salties
            }
            else -> {
                productos = arrayListOf() // Lista vacía por defecto
                imagenResId = R.drawable.simpletitle //Default o error
            }
        }

        imageView.setImageResource(imagenResId)

        var adaptador: AdaptadorProductos = AdaptadorProductos(this, productos)
        listview.adapter = adaptador

    }

    private fun agregarColdDrinks(): ArrayList<Product>{
        return arrayListOf(
            Product("Caramel Frap", R.drawable.caramelfrap, "Caramel syrup meets coffee, milk and ice and whipped cream and buttery caramel sauce layer the love on top.", 5.0),
            Product("Chocolate Frap", R.drawable.chocolatefrap, "Rich mocha-flavored sauce meets up with chocolaty chips, milk and ice for a blender bash.", 6.0),
            Product("Cold Brew", R.drawable.coldbrew, "Created by steeping medium-to-coarse ground coffee in room temperature water for 12 hours or longer.", 3.0),
            Product("Matcha Latte", R.drawable.matcha, "Leafy taste of matcha green tea powder with creamy milk and a little sugar for a flavor balance that will leave you feeling ready and raring to go.", 4.0),
            Product("Oreo Milkshake", R.drawable.oreomilkshake, "Chocolate ice cream, and oreo cookies. Topped with whipped cream with cocoa and chocolate syrup.", 7.0),
            Product("Peanut Milkshake", R.drawable.peanutmilkshake, "Vanilla ice cream, mixed with peanut butter and chocolate.", 7.0)
        )
    }

    fun agregarHotDrinks(): ArrayList<Product>{
        return arrayListOf(
            Product("Latte", R.drawable.latte, "Coffee drink made with espresso and steamed milk", 6.0),
            Product("Hot chocolate", R.drawable.hotchocolate, "Heated drink consisting of shaved chocolate, topped with marshmallows.", 5.0),
            Product("Espresso", R.drawable.espresso, "Full-flavored, concentrated form of coffee.", 4.0),
            Product("Chai Latte", R.drawable.chailatte, "Spiced tea concentrate with milk", 6.0),
            Product("Capuccino", R.drawable.capuccino, "A cappuccino is an espresso-based coffee drink, prepared with steamed foam.", 7.0),
            Product("American coffee", R.drawable.americano, "Espresso with hot water.", 2.0)
        )
    }

    fun agregarSweets(): ArrayList<Product>{
        return arrayListOf(
        Product("Blueberry cake", R.drawable.blueberrycake, "Vanilla cake flavor, topped with cheese topping and blueberries.", 6.0),
        Product("Chocolate cupcake", R.drawable.chocolatecupcake, "Chocolate cupcakes topped with butter cream and cherries.", 3.0),
        Product("Lemon tartalette", R.drawable.lemontartalette, "Pastry shell with a lemon flavored filling", 4.0),
        Product("Red Velvet cake", R.drawable.redvelvetcake, "Soft, moist, buttery cake topped with an easy cream cheese frosting.", 6.0),
        Product("Cherry cheesecake", R.drawable. strawberrycheesecake, "This cherry topped cheesecake is positively creamy and delicious and will be your new favorite dessert.", 7.0),
        Product("Tiramisu", R.drawable.tiramisu, "Coffee-flavored Italian dessert", 6.0)
        )
    }

    fun agregarSalties(): ArrayList<Product>{
        return arrayListOf(
        Product("Chicken crepes", R.drawable.chickencrepes, "Fine crepes stuffed with Alfredo chicken, spinach and mushrooms.", 6.0),
        Product("Club Sandwich", R.drawable.clubsandwich, "A delicious sandwich served with french fries.", 5.0),
        Product("Panini", R.drawable.hampanini, "Sandwich made with Italian bread  served warmed by grilling.", 4.0),
        Product("Philly cheese steak", R.drawable. phillycheesesteak, "Smothered in grilled onions, green peppers, mushrooms, and Provolone.", 6.0),
        Product("Nachos", R.drawable. nachos, "Tortilla chips layered with beef and   melted cheddar cheese. Served with fried beans, guacamole, pico de gallo, and sour topping.",  7.0)
        )
    }

    private class AdaptadorProductos: BaseAdapter{
        var productos = ArrayList<Product>()
        var contexto: Context? = null

        constructor(contexto: Context, productos: ArrayList<Product>){
            this.productos = productos
            this.contexto = contexto
        }

        override fun getCount(): Int {
            return productos.size
        }

        override fun getItem(p0: Int): Any {
            return productos[p0]
        }

        override fun getItemId(p0: Int): Long {
            return p0.toLong()
        }

        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
            var prod = productos[p0]
            var inflador = LayoutInflater.from(contexto)
            var vista = inflador.inflate(R.layout.producto_view, null)

            var imagen = vista.findViewById(R.id.producto_img) as ImageView
            var nombre = vista.findViewById(R.id.producto_nombre) as TextView
            var descripcion = vista.findViewById(R.id.producto_desc) as TextView
            var precio = vista.findViewById(R.id.producto_precio) as TextView

            imagen.setImageResource(prod.image)
            nombre.setText(prod.name)
            descripcion.setText(prod.description)
            precio.setText("$${prod.price}")

            return vista
        }

    }
}