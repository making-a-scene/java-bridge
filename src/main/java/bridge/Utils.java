package bridge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Utils {
    private static final int TOP_SPACE = 1;
    private static final int UNDER_SPACE = 0;
    private static final String HEAD_OF_BRIDGE = "[";
    private static final String TAIL_OF_BRIDGE = "]";
    private static final String BLANK = " ";

    // 게임 시작 전 초기 다리 생성
    public UsersBridgeCrossStatus makeInitialBridge() {
        List<List<String>> newBridge = new ArrayList<>();

        List<String> initialBridgeShape = Arrays.asList(HEAD_OF_BRIDGE, BLANK, BLANK, TAIL_OF_BRIDGE);
        newBridge.add(TOP_SPACE, initialBridgeShape);
        newBridge.add(UNDER_SPACE, initialBridgeShape);

        return new UsersBridgeCrossStatus(newBridge);
    }

}
