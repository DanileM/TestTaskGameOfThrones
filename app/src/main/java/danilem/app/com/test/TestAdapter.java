package danilem.app.com.test;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.List;

public class TestAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private Context context;
    private List<Model> listItems;

    TestAdapter(Context context, List<Model> listItems){
        this.context = context;
        this.listItems = listItems;
    }

    @Override
    public int getItemViewType(int position) {
        switch (listItems.get(position).type) {
            case 0:
                return Model.YOUR_MESSAGE_TYPE;
            case 1:
                return Model.INTERLOCUTOR_MESSAGE_TYPE;
            case 2:
                return Model.ADVERTISING_INTEGRATION_TYPE;
            default:
                return -1;
        }
    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view;
        switch (i) {
            case Model.YOUR_MESSAGE_TYPE:
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.your_message_item, viewGroup, false);
                return new YourMessageVH(view);
            case Model.INTERLOCUTOR_MESSAGE_TYPE:
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.interlocutor_message_item, viewGroup, false);
                return new InterlocutorMessageVH(view);
            case Model.ADVERTISING_INTEGRATION_TYPE:
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.advertising_integration_item, viewGroup, false);
                return new AdvertisingIntegrationVH(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        Model object = listItems.get(i);
        switch (object.type) {
            case Model.YOUR_MESSAGE_TYPE:
                Picasso.get().load(object.getImage()).into(((YourMessageVH) viewHolder).image);
                ((YourMessageVH) viewHolder).message.setText(object.getMessage());
                ((YourMessageVH) viewHolder).date.setText(object.getDate());
                ((YourMessageVH) viewHolder).message.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(context, "CALLBACK TO Activity", Toast.LENGTH_SHORT).show();
                    }
                });
                break;
            case Model.INTERLOCUTOR_MESSAGE_TYPE:
                Picasso.get().load(object.getImage()).into(((InterlocutorMessageVH) viewHolder).image);
                ((InterlocutorMessageVH) viewHolder).message.setText(object.getMessage());
                ((InterlocutorMessageVH) viewHolder).date.setText(object.getDate());
                break;
            case Model.ADVERTISING_INTEGRATION_TYPE:
                ((AdvertisingIntegrationVH) viewHolder).button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(AdmobVideoRewardHelper.mAd.isLoaded())
                        {
                            AdmobVideoRewardHelper.mAd.show();
                        }
                    }
                });
                break;
        }
    }


    class YourMessageVH extends RecyclerView.ViewHolder{
        @BindView(R.id.iv_your_image) ImageView image;
        @BindView(R.id.tv_your_message) TextView message;
        @BindView(R.id.tv_your_message_date) TextView date;

        private YourMessageVH(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    class InterlocutorMessageVH extends RecyclerView.ViewHolder{
        @BindView(R.id.iv_interlocutor_image) ImageView image;
        @BindView(R.id.tv_interlocutor_message) TextView message;
        @BindView(R.id.tv_interlocutor_message_date) TextView date;

        private InterlocutorMessageVH(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    class AdvertisingIntegrationVH extends RecyclerView.ViewHolder{
        @BindView(R.id.b_show_reward) Button button;

        private AdvertisingIntegrationVH(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}

