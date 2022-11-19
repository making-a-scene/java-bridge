package bridge;

import java.util.List;

import static bridge.Space.*;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private static final String STARTING_MESSAGE = "다리 건너기 게임을 시작합니다.";
    private static final String MESSAGE_TO_GET_SIZE = "다리의 길이를 입력해 주세요.";
    private static final String MESSAGE_TO_GET_SPACE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private static final String MESSAGE_TO_GET_WHETHER_RETRY_OR_NOT = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
    private static final String MESSAGE_TO_PRINT_RESULT = "최종 게임 결과";
    private static final String WHETHER_SUCCEED_OR_NOT = "게임 성공 여부: ";
    private static final String SUCCEED = "성공";
    private static final String FAILED = "실패";
    private static final String FAILED_REPRESENTED = "X";
    private static final String THE_NUMBER_OF_TRIAL = "총 시도한 횟수: ";

    public void printInitialMessages() {
        System.out.println(STARTING_MESSAGE);
        System.out.println(MESSAGE_TO_GET_SIZE);
    }

    public void printMessageToGetSpaceToMove() {
        System.out.println(MESSAGE_TO_GET_SPACE);
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printMap(UsersBridgeCrossStatus status) {
        List<String> up = status.getCurrentBridge().get(UP.getIndex());
        List<String> down = status.getCurrentBridge().get(DOWN.getIndex());
        up.forEach(System.out::print);
        System.out.println();
        down.forEach(System.out::print);
    }

    public void printMessageAfterFailure() {
        System.out.println(MESSAGE_TO_GET_WHETHER_RETRY_OR_NOT);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(int trials, UsersBridgeCrossStatus userStatus) {
        List<String> up = userStatus.getCurrentBridge().get(UP.getIndex());
        List<String> down = userStatus.getCurrentBridge().get(DOWN.getIndex());

        System.out.println(MESSAGE_TO_PRINT_RESULT);
        printMap(userStatus);
        System.out.print("\n\n");
        printSucceedOrFailed(userStatus);

        System.out.print(THE_NUMBER_OF_TRIAL + trials);
    }

    private static void printSucceedOrFailed(UsersBridgeCrossStatus userStatus) {
        System.out.print(WHETHER_SUCCEED_OR_NOT);
        if (userStatus.getSucceeded()) {
            System.out.println(SUCCEED);
            return;
        }
        System.out.println(FAILED);
    }

}
