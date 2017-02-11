package in.thegeekybaniya.institute;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class Inventory extends Fragment {

    ArrayList<InventoryPOJO> inventory;
     ListView lv;




    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view=inflater.inflate(R.layout.inventory_activity, container, false);
        inventory= new ArrayList<>();

        inventory.add(new InventoryPOJO("Blood A+", "Bottles", 5));
        inventory.add(new InventoryPOJO("Blood B+", "Bottles", 3));
        inventory.add(new InventoryPOJO("Blood AB+", "Bottles", 5));
        inventory.add(new InventoryPOJO("Kidney", "Unit(s)", 3));
        inventory.add(new InventoryPOJO("Eyes", "Unit(s)", 2));
        inventory.add(new InventoryPOJO("Heart", "Unit(s)", 6));
        inventory.add(new InventoryPOJO("Liver", "Unit(s)", 1));

        lv= (ListView) view.findViewById(R.id.lv);

        InventoryAdapter inAdp= new InventoryAdapter();
        lv.setAdapter(inAdp);


        return view;
    }



    private class InventoryAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return inventory.size();
        }

        @Override
        public Object getItem(int i) {
            return inventory.get(i);
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {


            LayoutInflater li= getActivity().getLayoutInflater();

            final InventoryPOJO inventoryPOJO=(InventoryPOJO)getItem(i);

            final InventoryHolder inHolder;

            if(view == null) {

                view = li.inflate(R.layout.inventory_display, null);

                inHolder = new InventoryHolder();
                inHolder.tvName = (TextView) view.findViewById(R.id.tvName);
                inHolder.tvUnit = (TextView) view.findViewById(R.id.tvUnit);
                inHolder.tvQty = (TextView) view.findViewById(R.id.tvQty);
                inHolder.btnDec = (Button) view.findViewById(R.id.btnDec);
                inHolder.btnInc = (Button) view.findViewById(R.id.btnInc);

                view.setTag(inHolder);
            }
                else {
                inHolder = (InventoryHolder) view.getTag();
            }
                    inHolder.tvName.setText( inventoryPOJO.getName());
                    inHolder.tvUnit.setText(inventoryPOJO.getUnit());
                    inHolder.tvQty.setText(Integer.toString(inventoryPOJO.getQty()));

                    inHolder.btnInc.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            inHolder.tvQty.setText((Integer.toString(inventoryPOJO.getQty()+1)));

                        }
                    });

            inHolder.btnDec.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    inHolder.tvQty.setText((Integer.toString(inventoryPOJO.getQty()-1)));
                }
            });













            return view;
        }
    }


    private class InventoryHolder {
        TextView tvName, tvUnit, tvQty;

        Button btnInc, btnDec;



    }
}
