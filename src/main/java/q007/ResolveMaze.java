package q007;

import java.util.*;

public class ResolveMaze {
    private static final String START = "S";
    private static final String END = "E";
    private static final String ROUTE = " ";


    private String[][] mazeArray;
    private int startX;
    private int startY;
    private Position correctPosition;
    private Deque<Position> positions = new ArrayDeque<>();

    public ResolveMaze(String[][] mazeArray) {
        this.mazeArray = mazeArray;
        execute();
    }

    private void execute() {
        setStartPosition();
        positions.add(new Position(startX, startY));
        findRoute();
    }

    private void setStartPosition() {
        for(var i = 0; i < mazeArray.length; i++) {
            for(var j = 0; j < mazeArray[i].length; j++) {
                if(Objects.equals(mazeArray[i][j], START)) {
                    startX = j;
                    startY = i;
                    System.out.println("startX = " + startX);
                    System.out.println("startY = " + startY);
                }
            }
        }
    }

    private void findRoute() {
        while(positions.isEmpty()) {
            System.out.println("size = " + positions.size());
            move(positions.remove());
            //どこかがバグっていて、無限ループするため抜ける
            if(correctPosition.getMoveCount() != 0) {
                break;
            }
        }
    }

    private void move(Position position) {
        moveUp(position);
        moveRight(position);
        moveDown(position);
        moveLeft(position);
    }

    private void moveUp(Position position) {
        var tmpPosition = new Position(
                position.getTmpX(),
                position.getTmpY() + 1,
                position.getTmpX(),
                position.getTmpY(),
                position.getMoveCount() + 1
        );
        if(tmpPosition.getTmpX() == position.getBeforeX() && tmpPosition.getTmpY() ==  position.getBeforeY()) {
            return;
        }
        movePosition(tmpPosition);
    }

    private void moveRight(Position position) {
        var tmpPosition = new Position(
                position.getTmpX() + 1,
                position.getTmpY(),
                position.getTmpX(),
                position.getTmpY(),
                position.getMoveCount() + 1
        );
        if(tmpPosition.getTmpX() == position.getBeforeX() && tmpPosition.getTmpY() ==  position.getBeforeY()) {
            return;
        }
        movePosition(tmpPosition);
    }

    private void moveDown(Position position) {
        var tmpPosition = new Position(
                position.getTmpX(),
                position.getTmpY() -1,
                position.getTmpX(),
                position.getTmpY(),
                position.getMoveCount() + 1
        );
        if(tmpPosition.getTmpX() == position.getBeforeX() && tmpPosition.getTmpY() ==  position.getBeforeY()) {
            return;
        }
        movePosition(tmpPosition);
    }

    private void moveLeft(Position position) {
        var tmpPosition = new Position(
                position.getTmpX() -1,
                position.getTmpY(),
                position.getTmpX(),
                position.getTmpY(),
                position.getMoveCount() + 1
        );
        if(tmpPosition.getTmpX() == position.getBeforeX() && tmpPosition.getTmpY() ==  position.getBeforeY()) {
            return;
        }
        movePosition(tmpPosition);
    }

    private void movePosition(Position position) {
        try {
            if(Objects.equals(mazeArray[position.getTmpY()][position.getTmpX()], ROUTE)) {
                positions.add(position);
            } else if(Objects.equals(mazeArray[position.getTmpY()][position.getTmpX()], END)) {
                if(Objects.isNull(correctPosition)
                        || correctPosition.getMoveCount() > position.getMoveCount()) {
                    correctPosition = position;
                    System.out.println("count = " + correctPosition.getMoveCount());
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
    }

    public Position getCorrectPosition() {
        return correctPosition;
    }
}
