package kapil.cast.video.screenmirroring.smarttv.kapil_developer_act;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.connectsdk.core.Util;
import com.connectsdk.device.ConnectableDevice;
import com.connectsdk.device.ConnectableDeviceListener;
import com.connectsdk.discovery.DiscoveryManager;
import com.connectsdk.discovery.DiscoveryManagerListener;
import com.connectsdk.service.DIALService;
import com.connectsdk.service.DeviceService;
import com.connectsdk.service.FireTVService;
import com.connectsdk.service.command.ServiceCommandError;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import kotlin.Unit;
import kapil.cast.video.screenmirroring.smarttv.kapil_developer_adp.kapil_developer_tv;
import kapil.cast.video.screenmirroring.smarttv.kapil_developer_dlg.kapil_developer_alr;
import kapil.cast.video.screenmirroring.smarttv.kapil_developer_dlg.kapil_developer_pass_code;
import kapil.cast.video.screenmirroring.smarttv.kapil_developer_if.kapil_developer_if_pass;
import kapil.cast.video.screenmirroring.smarttv.kapil_developer_if.kapil_developer_if_tv_show;
import kapil.cast.video.screenmirroring.smarttv.kapil_developer_if.kapil_developer_if_dlg_click;
import kapil.cast.video.screenmirroring.smarttv.kapil_developer_md.kapil_developer_md_even_show;
import kapil.cast.video.screenmirroring.smarttv.kapil_developer_md.kapil_developer_md_tv_model;
import kapil.cast.video.screenmirroring.smarttv.R;
import kapil.cast.video.screenmirroring.smarttv.kapil_developer_ut.kapil_developer_ut_mb;
import kapil.cast.video.screenmirroring.smarttv.kapil_developer_ut.kapil_developer_ut_tv_utls;
import kapil.cast.video.screenmirroring.smarttv.kapil_developer_ut.kapil_developer_ut_tv_connect;
import kapil.cast.video.screenmirroring.smarttv.kapil_developer_admob.kapil_developer_ap.kapil_developer_Inter;
import kapil.cast.video.screenmirroring.smarttv.kapil_developer_admob.kapil_developer_ap.kapil_developer_Native;

public class kapil_developer_cd extends AppCompatActivity implements DiscoveryManagerListener {
    public static String ipAddress = "";
    ImageView browserbtn, back;
    LinearLayout connectlayout, nodevice;
    RecyclerView recycler_view;
    kapil_developer_tv kapildevelopertv;
    kapil_developer_alr kapildeveloperalr;
    kapil_developer_pass_code kapildeveloperpasscode;
    SwipeRefreshLayout refreshLayout;

    FrameLayout adsContainer;
    boolean value = false;
    public boolean isConnect = false;
    String TAG = "ConnectActivityzzz";
    ArrayList<ConnectableDevice> connectableDevices = new ArrayList<>();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cast_tv_screen_device);

        DiscoveryManager.getInstance().addListener(this);

        kapil_developer_Inter.inter(this);
        kapil_developer_Native.banner(this,findViewById(R.id.adsContainer));
        browserbtn = findViewById(R.id.browserbtn);
        back = findViewById(R.id.back);
        connectlayout = findViewById(R.id.connectlayout);
        nodevice = findViewById(R.id.nodevice);
        recycler_view = findViewById(R.id.recycler_view);
        refreshLayout = findViewById(R.id.refreshLayout);

        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshLayout.setRefreshing(false);
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        recycler_view.setLayoutManager(new LinearLayoutManager(this));
        kapil_developer_tv kapildevelopertv = new kapil_developer_tv(new ArrayList(), this, new kapil_developer_if_tv_show() {
            @Override
            public void onItemClick(ConnectableDevice connectableDevice) {
                try {
                    connectToDevice(connectableDevice);
                } catch (Exception e) {

                }
            }
        });
        this.kapildevelopertv = kapildevelopertv;
        recycler_view.setAdapter(kapildevelopertv);
        WifiConnectReceve();
        kapil_developer_cd.this.callbackDone();

        browserbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(kapil_developer_cd.this, kapil_developer_ip.class));
                finish();
            }
        });
        ViewClickON();
    }


    private void ViewClickON() {
        connectableDevices.clear();
        connectableDevices.addAll(DiscoveryManager.getInstance().getCompatibleDevices().values());
        kapildevelopertv.setData(getDeviceArrayList(this.connectableDevices));
        if (DiscoveryManager.getInstance().getCompatibleDevices().values().size() > 0) {
            nodevice.setVisibility(View.GONE);
            connectlayout.setVisibility(View.VISIBLE);
            return;
        } else {
            nodevice.setVisibility(View.VISIBLE);
            connectlayout.setVisibility(View.GONE);

        }
    }

    public void connectToDevice(ConnectableDevice connectableDevice) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                StringBuilder stringBuilder = new StringBuilder();
                String unused = TAG;
                stringBuilder.append("connectToDevice ");
                stringBuilder.append(connectableDevice.getModelName());
                connectableDevice.addListener(kapil_developer_cd.this.connectableDeviceListener);
                connectableDevice.setPairingType(DeviceService.PairingType.PIN_CODE);
                connectableDevice.connect();
            }
        });
        try {
            kapil_developer_ut_mb.connect(this, "start", connectableDevice.getId(), kapil_developer_ut_tv_utls.getTVcatgary(connectableDevice));

        } catch (Exception e) {
            e.printStackTrace();
        }
        this.kapildeveloperalr = new kapil_developer_alr(this, new kapil_developer_if_dlg_click() {
            @Override
            public void onClick() {
                CastToggelConnection();
            }
        });
        kapildeveloperpasscode = new kapil_developer_pass_code(this, new kapil_developer_if_pass() {
            @Override
            public void onCancel() {

            }

            @Override
            public void onCompelete(String trim) {
                try {
                    connectableDevice.sendPairingKey(trim);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void CastToggelConnection() {

        if (kapil_developer_ut_tv_connect.getInstance().getConnectableDevice() != null) {
            if (kapil_developer_ut_tv_connect.getInstance().getConnectableDevice().isConnected()) {
                kapil_developer_ut_tv_connect.getInstance().getConnectableDevice().disconnect();
            }
            kapil_developer_ut_tv_connect.getInstance().getConnectableDevice().removeListener(connectableDeviceListener);
            kapil_developer_ut_tv_connect.getInstance().getConnectableDevice().disconnect();
        }

    }

    private void DeviceConnectionFail(ConnectableDevice device) {
        if (device != null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Failed to connect to ");
            stringBuilder.append(device.getIpAddress());
        }
        if (kapil_developer_ut_tv_connect.getInstance().getConnectableDevice() != null) {
            kapil_developer_ut_tv_connect.getInstance().getConnectableDevice().removeListener(connectableDeviceListener);
            kapil_developer_ut_tv_connect.getInstance().getConnectableDevice().disconnect();
        }
    }

    static class ConnectService {
        static final int[] PairDeviceConnectService;

        static {
            int[] iArr = new int[DeviceService.PairingType.values().length];
            PairDeviceConnectService = iArr;
            try {
                iArr[DeviceService.PairingType.FIRST_SCREEN.ordinal()] = 1;
                PairDeviceConnectService[DeviceService.PairingType.PIN_CODE.ordinal()] = 2;
                PairDeviceConnectService[DeviceService.PairingType.MIXED.ordinal()] = 3;
                PairDeviceConnectService[DeviceService.PairingType.NONE.ordinal()] = 4;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void connectDeviceReady(final ConnectableDevice connectableDevice) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("onDeviceReady: ");
                stringBuilder.append(connectableDevice.getConnectedServiceNames());
                Toast.makeText(kapil_developer_cd.this, "Connect success", Toast.LENGTH_SHORT).show();
                kapil_developer_ut_tv_connect.getInstance().setConnectableDevice(connectableDevice);
                EventBus.getDefault().post(new kapil_developer_md_even_show("KEY_CONNECT"));
                isConnect = true;
            }
        });

    }


    private ArrayList<kapil_developer_md_tv_model> getDeviceArrayList(ArrayList<ConnectableDevice> arrayList) {
        String mName;
        ArrayList<kapil_developer_md_tv_model> ViewArrayList = null;
        try {
            ArrayList<kapil_developer_md_tv_model> findarrayList = new ArrayList<>();
            for (int i = 0; i < arrayList.size(); i++) {
                try {
                    ConnectableDevice connectableDevice = arrayList.get(i);
                    if (connectableDevice.getServiceId().equalsIgnoreCase(DIALService.ID)) {
                        if (connectableDevice.getFriendlyName() != null && connectableDevice.getFriendlyName().contains(FireTVService.ID)) {
                            ipAddress = connectableDevice.getIpAddress();

                        }
                    } else {
                        if (connectableDevice.getFriendlyName() != null) {
                            mName = connectableDevice.getFriendlyName();
                        } else {
                            mName = connectableDevice.getModelName();
                        }
                        ArrayList arrayListNew = new ArrayList();
                        arrayListNew.add(connectableDevice);
                        if (findarrayList.size() == 0) {
                            findarrayList.add(new kapil_developer_md_tv_model(mName, arrayListNew));
                        } else {
                            int pos = 0;
                            while (true) {
                                if (pos >= findarrayList.size()) {
                                    break;
                                } else if (mName.equalsIgnoreCase(findarrayList.get(pos).getTv())) {
                                    findarrayList.get(pos).getDeviceArrayList().add(connectableDevice);
                                    value = true;
                                    break;
                                } else {
                                    pos++;
                                    value = true;
                                }

                            }
                            if (value) {
                                findarrayList.add(new kapil_developer_md_tv_model(mName, arrayListNew));
                            }
                        }

                    }
                } catch (Exception e) {
                    ViewArrayList = findarrayList;
                    e.printStackTrace();
                    return ViewArrayList;
                }


            }

            return findarrayList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ViewArrayList;
    }

    public Unit callbackFail() {
        return Unit.INSTANCE;
    }

    public Unit callbackDone() {
        return Unit.INSTANCE;
    }

    private void WifiConnectReceve() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.wifi.STATE_CHANGE");
        registerReceiver(this.receiver, intentFilter);
    }


    @Override
    public void onDeviceAdded(DiscoveryManager manager, ConnectableDevice device) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onDeviceAdded: ");
        stringBuilder.append(device.getId());
        Util.runOnUI(new Runnable() {
            @Override
            public void run() {
                connectableDevices.clear();
                connectableDevices.addAll(DiscoveryManager.getInstance().getCompatibleDevices().values());
                kapil_developer_tv kapildevelopertv = kapil_developer_cd.this.kapildevelopertv;
                kapil_developer_cd kapildevelopercd = kapil_developer_cd.this;
                kapildevelopertv.setData(kapildevelopercd.getDeviceArrayList(kapildevelopercd.connectableDevices));
                if (DiscoveryManager.getInstance().getCompatibleDevices().values().size() > 0) {
                    nodevice.setVisibility(View.GONE);
                    connectlayout.setVisibility(View.VISIBLE);
                } else {
                    nodevice.setVisibility(View.VISIBLE);
                    connectlayout.setVisibility(View.GONE);

                }
                StringBuilder stringBuilder1 = new StringBuilder();
                stringBuilder1.append("onDeviceAdded: 1");
                stringBuilder1.append(connectableDevices.size());

            }
        });
    }

    @Override
    public void onDeviceUpdated(DiscoveryManager manager, ConnectableDevice device) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onDeviceUpdate ");
        stringBuilder.append(device.getId());
        Util.runOnUI(new Runnable() {
            @Override
            public void run() {
                connectableDevices.clear();
                connectableDevices.addAll(DiscoveryManager.getInstance().getCompatibleDevices().values());
                if (DiscoveryManager.getInstance().getCompatibleDevices().values().size() > 0) {
                    nodevice.setVisibility(View.GONE);
                    connectlayout.setVisibility(View.VISIBLE);
                } else {
                    nodevice.setVisibility(View.VISIBLE);
                    connectlayout.setVisibility(View.GONE);

                }
                kapil_developer_tv kapildevelopertv = kapil_developer_cd.this.kapildevelopertv;
                kapil_developer_cd kapildevelopercd = kapil_developer_cd.this;
                kapildevelopertv.setData(kapildevelopercd.getDeviceArrayList(kapildevelopercd.connectableDevices));
            }
        });
    }

    @Override
    public void onDeviceRemoved(DiscoveryManager manager, ConnectableDevice device) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onDeviceRemove ");
        stringBuilder.append(device.getId());
        Util.runOnUI(new Runnable() {
            @Override
            public void run() {
                connectableDevices.clear();
                if (DiscoveryManager.getInstance().getCompatibleDevices().values().size() > 0) {
                    nodevice.setVisibility(View.GONE);
                    connectlayout.setVisibility(View.VISIBLE);
                } else {
                    nodevice.setVisibility(View.VISIBLE);
                    connectlayout.setVisibility(View.GONE);

                }
                kapil_developer_tv kapildevelopertv = kapil_developer_cd.this.kapildevelopertv;
                kapil_developer_cd kapildevelopercd = kapil_developer_cd.this;
                kapildevelopertv.setData(kapildevelopercd.getDeviceArrayList(kapildevelopercd.connectableDevices));
            }
        });
    }

    @Override
    public void onDiscoveryFailed(DiscoveryManager manager, ServiceCommandError error) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onDiscoveryFailed ");
        stringBuilder.append(error.getMessage());
        Util.runOnUI(new Runnable() {
            @Override
            public void run() {
                connectableDevices.clear();
                if (DiscoveryManager.getInstance().getCompatibleDevices().values().size() > 0) {
                    nodevice.setVisibility(View.GONE);
                    connectlayout.setVisibility(View.VISIBLE);
                } else {
                    nodevice.setVisibility(View.VISIBLE);
                    connectlayout.setVisibility(View.GONE);

                }
                kapil_developer_tv kapildevelopertv = kapil_developer_cd.this.kapildevelopertv;
                kapil_developer_cd kapildevelopercd = kapil_developer_cd.this;
                kapildevelopertv.setData(kapildevelopercd.getDeviceArrayList(kapildevelopercd.connectableDevices));
            }
        });
    }
    private ConnectableDeviceListener connectableDeviceListener = new ConnectableDeviceListener() {
        @Override
        public void onDeviceReady(ConnectableDevice device) {
            if (device.getFriendlyName() != null) {
                device.getFriendlyName();
            } else {
                device.getModelName();
            }
            if (!isConnect) {
                connectDeviceReady(device);
                isConnect = true;
            } else {
            }

        }

        @Override
        public void onDeviceDisconnected(ConnectableDevice device) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("onDeviceDisconnected: ");
            stringBuilder.append(device.getModelName());
            try {
                if (device.getServiceDescription() != null && device.getServiceDescription().getManufacturer() != null) {
                    kapil_developer_ut_mb.connect(kapil_developer_cd.this, "fail", device.getId(), device.getServiceDescription().getManufacturer());

                } else {
                    kapil_developer_ut_mb.connect(kapil_developer_cd.this, "fail", device.getId(), kapil_developer_ut_tv_utls.getTVcatgary(device));
                }
            } catch (Exception e) {
                kapil_developer_ut_mb.connect(kapil_developer_cd.this, "fail", device.getId(), "");
                e.printStackTrace();
            }
            if (device.getFriendlyName() != null) {
                device.getFriendlyName();
            } else {
                device.getModelName();
            }
        }

        @Override
        public void onPairingRequired(ConnectableDevice device, DeviceService service, DeviceService.PairingType pairingType) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("onPairingRequired: ");
            stringBuilder.append(device.getModelName());
            if (device.getFriendlyName() != null) {
                device.getFriendlyName();
            } else {
                device.getModelName();
            }
            int i = ConnectService.PairDeviceConnectService[pairingType.ordinal()];
            if (i == 1) {
                try {
                    if (kapildeveloperalr == null) {
                        return;
                    }
                    kapildeveloperalr.show();
                } catch (Exception e) {
                    e.printStackTrace();

                }
            } else if (i != 2 && i != 3) {

            } else {
                try {
                    if (kapildeveloperalr == null) {
                        return;
                    }
                    kapildeveloperalr.show();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }


        }

        @Override
        public void onCapabilityUpdated(ConnectableDevice device, List<String> added, List<String> removed) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("onCapabilityUpdated: ");
            stringBuilder.append(device.getModelName());
            if (device.getFriendlyName() != null) {
                device.getFriendlyName();
            } else {
                device.getModelName();
            }
        }

        @Override
        public void onConnectionFailed(ConnectableDevice device, ServiceCommandError error) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("onConnectionFailed: ");
            stringBuilder.append(device.getModelName());
            try {
                if (device.getServiceDescription() != null && device.getServiceDescription().getManufacturer() != null) {
                    kapil_developer_ut_mb.connect(kapil_developer_cd.this, "fail", device.getId(), device.getServiceDescription().getManufacturer());
                } else {
                    kapil_developer_ut_mb.connect(kapil_developer_cd.this, "fail", device.getId(), kapil_developer_ut_tv_utls.getTVcatgary(device));
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
            DeviceConnectionFail(device);
            if (device.getFriendlyName() != null) {
                device.getFriendlyName();
            } else {
                device.getModelName();
            }
        }
    };
    private BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if ("android.net.wifi.STATE_CHANGE".equals(intent.getAction())) {
                NetworkInfo networkInfo = intent.getParcelableExtra("networkInfo");
            }
        }
    };

    @Override
    public void onBackPressed() {
        kapil_developer_Inter.back(this);
    }

}