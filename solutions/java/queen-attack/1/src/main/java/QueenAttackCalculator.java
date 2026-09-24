import java.util.Objects;

class QueenAttackCalculator {
    private final Queen queenW;
    private final Queen queenB;

    public QueenAttackCalculator(Queen queenW, Queen queenB) {
        if (queenW == null || queenB == null) {
            throw new IllegalArgumentException("You must supply valid positions for both Queens.");
        }
        if(queenW.equals(queenB)){
            throw new IllegalArgumentException("Queens cannot occupy the same position.");
        }
        this.queenW = queenW;
        this.queenB = queenB;
    }

    boolean canQueensAttackOneAnother() {
        if (queenW.getColumn() == queenB.getColumn()) return true;
        if (queenW.getRow() == queenB.getRow()) return true;
        if (queenW.columnMinusRow() == queenB.columnMinusRow()) return true;
        return queenW.columnPlusRow() == queenB.columnPlusRow();
    }
}

class Queen {
    private final int column;
    private final int row;

    public Queen(int row, int column) {
        if (row < 0) throw new IllegalArgumentException("Queen position must have positive row.");
        if (column < 0) throw new IllegalArgumentException("Queen position must have positive column.");
        if (row > 7) throw new IllegalArgumentException("Queen position must have row <= 7.");
        if (column > 7) throw new IllegalArgumentException("Queen position must have column <= 7.");

        this.column = column;
        this.row = row;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Queen queen = (Queen) o;
        return column == queen.column &&
                row == queen.row;
    }

    @Override
    public int hashCode() {
        return Objects.hash(column, row);
    }

    public int getColumn() {
        return column;
    }

    public int getRow() {
        return row;
    }

    public int columnMinusRow() {
        return column - row;
    }

    public int columnPlusRow() {
        return column + row;
    }
}
