package aifrru.flowmeter.flow.ui;

import aifrru.flowmeter.weka.WekaXMeans;

import java.io.File;

public class FlowFileInfo {

    private File filepath;
    private WekaXMeans xMeans;

    public FlowFileInfo(File filepath, WekaXMeans xMeans) {
        this.filepath = filepath;
        this.xMeans = xMeans;
    }


    @Override
    public String toString() {
        return filepath.getName();
    }

    public File getFilepath() {
        return filepath;
    }

    public WekaXMeans getxMeans() {
        return xMeans;
    }
}
