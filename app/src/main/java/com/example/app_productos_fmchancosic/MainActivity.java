package com.example.app_productos_fmchancosic;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //Representan a los elementos de la interfaz gráfica
    EditText txtId, txtDescripcion, txtStock, txtPrecioUnitario, txtTasaIVA;
    Productos productos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtId = findViewById(R.id.txtId);
        txtDescripcion = findViewById(R.id.txtDescripcion);
        txtStock = findViewById(R.id.txtStock);
        txtPrecioUnitario = findViewById(R.id.txtPrecioUnitario);
        txtTasaIVA = findViewById(R.id.txtTasaIVA);
        productos = new Productos(this,"productos.db",1);
    }

    public void cmdCreate_OnClick(View v){
        Producto p= productos.Create(
                Integer.parseInt(txtId.getText().toString()),
                txtDescripcion.getText().toString(),
                Integer.parseInt(txtStock.getText().toString()),
                Double.parseDouble(txtPrecioUnitario.getText().toString()),
                Double.parseDouble(txtTasaIVA.getText().toString()));
        Toast.makeText(this, "DATOS INSERTADOS CON ÉXITO", Toast.LENGTH_SHORT).show();
    }

    public void cmdReadById_OnClick(View v){
        Producto p = productos.Read_ById(Integer.parseInt(txtId.getText().toString()));
        if(p!=null){
            txtId.setText(""+p.Id);
            txtDescripcion.setText(p.Descripcion);
            txtStock.setText(""+p.Stock);
            txtPrecioUnitario.setText(""+p.Precio_unitario);
            txtTasaIVA.setText(""+p.Tasa_iva);
            Toast.makeText(this, "DATOS ENCONTRADOS!!", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this, "PRODUCTO NO ENCONTRADO!!", Toast.LENGTH_SHORT).show();
        }
    }

    public void cmdUpdate_onClick(View v){
        productos.Update(
                Integer.parseInt(txtId.getText().toString()),
                txtDescripcion.getText().toString(),
                Integer.parseInt(txtStock.getText().toString()),
                Double.parseDouble(txtPrecioUnitario.getText().toString()),
                Double.parseDouble(txtTasaIVA.getText().toString()));
        Toast.makeText(this, "DATOS INSERTADOS!!", Toast.LENGTH_SHORT).show();
    }

    public void cmdDelete_onClick(View v){
        productos.Delete(Integer.parseInt(txtId.getText().toString()));
        txtId.setText("");
        txtDescripcion.setText("");
        txtStock.setText("");
        txtPrecioUnitario.setText("");
        txtTasaIVA.setText("");
        Toast.makeText(this, "DATOS BORRADOS OK !!", Toast.LENGTH_SHORT).show();
    }
}