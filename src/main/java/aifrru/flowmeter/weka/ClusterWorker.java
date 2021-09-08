package aifrru.flowmeter.weka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import java.io.File;

public class ClusterWorker extends SwingWorker<WekaXMeans,Integer> {

    protected static final Logger logger = LoggerFactory.getLogger(ClusterWorker.class);

    public static final int FLOW_CSV = 1;
    public static final int URL_CSV = 2;

    private File csvfile;
    private int  csv_source;

    public ClusterWorker(File csvfile,int src) {
        this.csvfile = csvfile;
        csv_source = src;
    }

    @Override
    protected WekaXMeans doInBackground() throws Exception {
        logger.info("build file:{}",csvfile.getPath());

        WekaXMeans xMeans = null;
        switch (csv_source) {
            case FLOW_CSV:
                xMeans = new WekaXMeans(WekaFactory.loadFlowCsv(csvfile));
                break;
            case URL_CSV:
                xMeans = new WekaXMeans(WekaFactory.loadURLCsv(csvfile));
                break;
        }
        if (xMeans != null) {
            xMeans.build();
        }

        return xMeans;
    }

    @Override
    protected void done() {
        super.done();
    }
}
