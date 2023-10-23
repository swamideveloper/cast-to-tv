package kapil.cast.video.screenmirroring.smarttv.kapil_developer_adp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.connectsdk.device.ConnectableDevice;
import com.connectsdk.discovery.DiscoveryManager;
import com.connectsdk.service.FireTVService;
import com.connectsdk.service.RokuService;
import com.connectsdk.service.WebOSTVService;

import java.util.ArrayList;
import java.util.List;

import kapil.cast.video.screenmirroring.smarttv.kapil_developer_if.kapil_developer_if_tv_show;
import kapil.cast.video.screenmirroring.smarttv.kapil_developer_md.kapil_developer_md_tv_model;
import kapil.cast.video.screenmirroring.smarttv.R;

public class kapil_developer_tv extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ArrayList<kapil_developer_md_tv_model> kapildevelopermdtvmodels;
    private Context context;
    private kapil_developer_if_tv_show kapildeveloperiftvshow;


    public kapil_developer_tv(ArrayList<kapil_developer_md_tv_model> arrayList, Context context, kapil_developer_if_tv_show kapildeveloperiftvshow) {
        this.kapildevelopermdtvmodels = new ArrayList<>();
        this.kapildevelopermdtvmodels = arrayList;
        this.context = context;
        this.kapildeveloperiftvshow = kapildeveloperiftvshow;
    }

    public void setData(List<kapil_developer_md_tv_model> list) {
        this.kapildevelopermdtvmodels.clear();
        this.kapildevelopermdtvmodels.addAll(list);
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewMAinHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.cast_tv_screen_adp_show, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        try {
            kapil_developer_md_tv_model kapildevelopermdtvmodel = this.kapildevelopermdtvmodels.get(position);
            String nametv = kapildevelopermdtvmodel.getTv();
            final ArrayList<ConnectableDevice> deviceArrayList = kapildevelopermdtvmodel.getDeviceArrayList();
            ((ViewMAinHolder) holder).televisionName.setText(nametv);

            DiscoveryManager.getInstance().getCapabilityFilters().size();
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < deviceArrayList.size(); i++) {
                if (i == kapildevelopermdtvmodel.getDeviceArrayList().size() - 1) {
                    stringBuilder.append(deviceArrayList.get(i).getConnectedServiceNames());
                } else {
                    stringBuilder.append(deviceArrayList.get(i).getConnectedServiceNames());
                    stringBuilder.append(", ");
                }
            }

            ((ViewMAinHolder) holder).mobileCatagory.setText(stringBuilder.toString());
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (kapildeveloperiftvshow != null) {
                        if (deviceArrayList.size() == 1) {
                            kapildeveloperiftvshow.onItemClick(deviceArrayList.get(0));
                        }

                        for (int i = 0; i < deviceArrayList.size(); i++) {
                            ConnectableDevice connectableDevice = deviceArrayList.get(i);
                            if (connectableDevice.getConnectedServiceNames() != null) {
                                if (connectableDevice.getConnectedServiceNames().equalsIgnoreCase(WebOSTVService.ID) || connectableDevice.getConnectedServiceNames().equalsIgnoreCase(FireTVService.ID) || connectableDevice.getConnectedServiceNames().equalsIgnoreCase(RokuService.ID)) {
                                    kapildeveloperiftvshow.onItemClick(connectableDevice);
                                    break;
                                }
                            }
                        }
                        kapildeveloperiftvshow.onItemClick(deviceArrayList.get(0));
                    }
                }

            });
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    @Override
    public int getItemCount() {
        return kapildevelopermdtvmodels.size();
    }

    private class ViewMAinHolder extends RecyclerView.ViewHolder {
        TextView mobileCatagory;
        TextView televisionName;

        public ViewMAinHolder(@NonNull View itemView) {
            super(itemView);
           televisionName =  itemView.findViewById(R.id.televisionName);
           mobileCatagory =  itemView.findViewById(R.id.mobileCatagory);

        }
    }
}
