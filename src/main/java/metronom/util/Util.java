package metronom.util;

public class Util {

	public static final String SPLIT_CHARACTER = ",";

	public static final int ARGUMENTS_SIZE = 2;

	public static boolean isValidBoardSize(int size) {
		return (size >= 3 && size <= 10);
	}

	public static boolean isNumber(String str) {
        try {
            Integer.parseInt(str);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

	public static boolean isValidInput(String input) {
		String [] splitInput = input.split(SPLIT_CHARACTER);
		return (input!=null &&
				!input.isEmpty() &&
				input.contains(SPLIT_CHARACTER) &&
				splitInput.length == ARGUMENTS_SIZE &&
				isNumber(splitInput[0]) &&
				isNumber(splitInput[1]));
	}

	public static boolean isMovementInRange (String input, int rows, int cols) {
		int row;
		int column;
		boolean result = false;
		if (isValidInput(input)) {
			row = getRowValue(input);
			column = getColumnValue(input);
			if ((row > 0 && row <= rows) && (column > 0 && column <= cols)) {
				result = true;
			}
		}
		return result;
	}

	private static Integer convertStringToInteger (String number) {
		return Integer.parseInt(number);
	}

	public static int getColumnValue(String input) {
		Integer result = 0;
		String[] values;
		if (isValidInput(input)) {
			values = input.split(SPLIT_CHARACTER);
			result = convertStringToInteger(values[1]);
		}

		return result;
	}

	public static int getRowValue(String input) {
		Integer result = 0;
		String[] values;
		if (isValidInput(input)) {
			values = input.split(SPLIT_CHARACTER);
			result = convertStringToInteger(values[0]);
		}

		return result;

	}
}
