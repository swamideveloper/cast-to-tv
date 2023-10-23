package kapil.cast.video.screenmirroring.smarttv.kapil_developer_adp;

import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.Filter;


import org.json.JSONArray;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import kapil.cast.video.screenmirroring.smarttv.kapil_developer_act.kapil_developer_bra;
import kapil.cast.video.screenmirroring.smarttv.R;


public class kapil_developer_serch_auto extends ArrayAdapter<String> {
    ArrayList<String> dataArray;
    Context context;

    public kapil_developer_serch_auto(kapil_developer_bra kapildeveloperbra, int i) {
        super(kapildeveloperbra, i);
        this.dataArray = new ArrayList<>();
        this.context = kapildeveloperbra;
    }


    @Override
    public int getCount() {
        return this.dataArray.size();
    }

    @Override
    public String getItem(int i) {
        try {
            return this.dataArray.get(i);
        } catch (Exception unused) {
            return "";
        }
    }

    @Override
    public Filter getFilter() {
        return new Filter() {

            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                FilterResults results = new FilterResults();
                if (charSequence != null) {
                    InputStream inputStream = null;
                    try {
                        try {
                            if (!charSequence.toString().startsWith("http://") && !charSequence.toString().startsWith("https://") && !charSequence.toString().equals(kapil_developer_serch_auto.this.context.getResources().getString(R.string.home))) {
                                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL("http://suggestqueries.google.com/complete/search?client=firefox&q=" + charSequence.toString()).openConnection();
                                try {
                                    try {
                                        inputStream = httpURLConnection.getInputStream();
                                        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"), 8192);
                                        StringBuilder stringBuilder = new StringBuilder();
                                        while (true) {
                                            String readLine = reader.readLine();
                                            if (readLine == null) {
                                                break;
                                            }
                                            stringBuilder.append(readLine);
                                        }
                                        JSONArray jSONArray = new JSONArray(stringBuilder.toString()).getJSONArray(1);
                                        ArrayList arrayList = new ArrayList();
                                        for (int i = 0; i < jSONArray.length(); i++) {
                                            arrayList.add(jSONArray.getString(i));
                                        }
                                        results.values = arrayList;
                                        results.count = arrayList.size();
                                        kapil_developer_serch_auto.this.dataArray = arrayList;
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                        if (inputStream != null) {
                                            try {
                                                inputStream.close();
                                            } catch (Exception e3) {
                                                e3.printStackTrace();
                                            }
                                        }
                                        return results;
                                    }
                                } catch (Throwable th) {
                                    if (inputStream != null) {
                                        try {
                                            inputStream.close();
                                        } catch (Exception e4) {
                                            e4.printStackTrace();
                                        }
                                    }
                                    if (httpURLConnection != null) {
                                        httpURLConnection.disconnect();
                                    }
                                    throw th;
                                }
                            }
                        } catch (Exception unused) {
                        }
                    } catch (Throwable th2) {
                        try {
                            throw th2;
                        } catch (Throwable th3) {
                            th3.printStackTrace();
                        }
                    }
                }
                return results;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                if (filterResults == null || filterResults.count <= 0) {
                    kapil_developer_serch_auto.this.notifyDataSetInvalidated();
                } else {
                    kapil_developer_serch_auto.this.notifyDataSetChanged();
                }
            }
        };
    }
}
