package kapil.cast.video.screenmirroring.smarttv.kapil_developer_cr;



import com.yanzhenjie.andserver.RequestHandler;

import org.apache.httpcore.HttpException;
import org.apache.httpcore.HttpRequest;
import org.apache.httpcore.HttpResponse;
import org.apache.httpcore.entity.StringEntity;
import org.apache.httpcore.protocol.HttpContext;

import java.io.IOException;




public class InformationHandler implements RequestHandler {
    @Override
    public void handle(HttpRequest httpRequest, HttpResponse httpResponse, HttpContext httpContext) throws HttpException, IOException {
        StringEntity stringEntity = new StringEntity("" + kapil_developer_web.ipTextView + ":" + kapil_developer_web.portweb, "utf-8");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("handle: ");
        stringBuilder.append(stringEntity);
        httpResponse.setEntity(stringEntity);
    }
}
