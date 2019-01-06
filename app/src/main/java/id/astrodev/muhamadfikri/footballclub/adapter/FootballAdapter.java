package id.astrodev.muhamadfikri.footballclub.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import id.astrodev.muhamadfikri.footballclub.R;
import id.astrodev.muhamadfikri.footballclub.model.DetailFootballTeam;
import id.astrodev.muhamadfikri.footballclub.view.DetailFootballActivity;

import java.util.List;

public class FootballAdapter extends RecyclerView.Adapter<FootballAdapter.MyViewHolder> {

    private final Context context;
    private List<DetailFootballTeam> listData;

    public FootballAdapter(Context context, List<DetailFootballTeam> listData) {
        this.context = context;
        this.listData = listData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View viewRoot = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_row, viewGroup, false);
        return new MyViewHolder(viewRoot);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        DetailFootballTeam myModel = listData.get(i);
        myViewHolder.bind(myModel);
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private CardView cv;
        private TextView itemName;
        private ImageView itemImage;

        private MyViewHolder(@NonNull View itemView) {
            super(itemView);
            cv = (CardView) itemView.findViewById(R.id.cv);
            itemName = (TextView) itemView.findViewById(R.id.item_name);
            itemImage = (ImageView) itemView.findViewById(R.id.imageView);
        }

        private void bind(final DetailFootballTeam data) {
            itemName.setText(data.getStrTeam_());
            Picasso.get().load(data.getStrTeamBadge_()).into(itemImage);
            cv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(context, DetailFootballActivity.class);
                    i.putExtra("data", data);
                    i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(i);
                }
            });
        }

    }

}
