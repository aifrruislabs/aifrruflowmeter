package aifrru.flowmeter.jnetpcap.worker;

import aifrru.flowmeter.jnetpcap.BasicFlow;

public interface FlowGenListener {
    void onFlowGenerated(BasicFlow flow);
}
