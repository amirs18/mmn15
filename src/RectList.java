public class RectList {
    // variable creation
    private  RectNode _head ;

    /**
     * first constructor empty constructor creates an empty  RectList
     */
    public RectList() {
        this._head=null;
    }

    /**
     *addRect is a function that adds a node to the RectList with the values of a given rectangle unless the given rectangle already exist in the RectList
     * space complexity O(1), running complexity O(n)
     * @param r the given rectangle
     */
    public void addRect(RectangleA r){
        RectNode _temp_h=_head;
        if (_head==null) {
            _head=new RectNode(r);
            return;
        }
        else {
            while (_temp_h.getNext() != null) {
                if (_temp_h.getRect().equals(r))
                    return;
                _temp_h = _temp_h.getNext();
            }
            _temp_h.setNext(new RectNode(r));
        }
    }

    /**
     * howManyWithPoint is a function that returns the number of rectangles that have the same SW point like the one given
     * space complexity O(1), running complexity O(n)
     * @param p the given SW Point
     * @return the number of rectangles with the given SW point
     */
    public int howManyWithPoint(Point p){
        RectNode _temp_h=_head;
        int counter=0;
        while (_temp_h!=null){
            if (_temp_h.getRect().getPointSW().equals(p))
                counter=counter+1;
            _temp_h=_temp_h.getNext();
        }
        return counter;
    }

    /**
     * longestDiagonal is a function that returns the length of the longest diagonal in all the rectangles in the list
     * space complexity O(1), running complexity O(n)
     * @return the length of the longest diagonal in all the rectangles in the list
     */
    public double longestDiagonal(){
        if (_head==null)
            return 0;
        double length=0;
        RectNode _temp_h=_head;
        while (_temp_h!=null){
            length=Math.max(length,_temp_h.getRect().getDiagonalLength());
            _temp_h=_temp_h.getNext();
        }
        return length;
    }

    /**
     * mostLeftRect is a function that returns the most left SW Point in all the rectangles in the list
     * space complexity O(1), running complexity O(n)
     * @return the most left SW Point in all the rectangles in the list
     */
    public Point mostLeftRect(){
        if (_head==null)
            return null;
        Point _temp_p=_head.getRect().getPointSW();
        RectNode _temp_h=_head;
        while (_temp_h!=null){
            if (_temp_h.getRect().getPointSW().isLeft(_temp_p))
                _temp_p= _temp_h.getRect().getPointSW();
            _temp_h=_temp_h.getNext();
        }
        return new Point(_temp_p);
    }

    /**
     * mostLeftRect is a function that returns the highest NE Point in all the rectangles in the list
     * space complexity O(1), running complexity O(n)
     * @return the highest NE Point in all the rectangles in the list
     */
    public Point highestRect(){
        if (_head==null)
            return null;
        Point _temp_p=_head.getRect().getPointNE();
        RectNode _temp_h=_head;
        while (_temp_h!=null){
            if (_temp_h.getRect().getPointNE().isAbove(_temp_p))
                _temp_p= _temp_h.getRect().getPointNE();
            _temp_h=_temp_h.getNext();
        }
        return new Point(_temp_p);
    }

    /**
     * minimalContainer is a function that creates and returns the minimal rectangle that can contain all the rectangles in the list
     * space complexity O(1), running complexity O(n)
     * @return the minimal rectangle that can contain all the rectangles in the list
     */
    public RectangleA minimalContainer(){
        if (_head==null)
            return null;
        Point _temp_right=_head.getRect().getPointNE();
        Point _temp_high=_head.getRect().getPointNE();
        Point _temp_left=_head.getRect().getPointSW();
        Point _temp_low=_head.getRect().getPointSW();

        RectNode _temp_h=_head;
        while (_temp_h!=null){
            //gets the most right Point in the list
            if (_temp_h.getRect().getPointNE().isRight(_temp_right))
                _temp_right= _temp_h.getRect().getPointNE();
            //gets the highest Point in the list
            if (_temp_h.getRect().getPointNE().isAbove(_temp_high))
                _temp_high= _temp_h.getRect().getPointNE();
            //gets the most left Point in the list
            if (_temp_h.getRect().getPointSW().isLeft(_temp_left))
                _temp_left= _temp_h.getRect().getPointSW();
            //gets the highest Point in the list
            if (_temp_h.getRect().getPointSW().isUnder(_temp_low))
                _temp_low= _temp_h.getRect().getPointSW();
            _temp_h=_temp_h.getNext();
        }
        // returns a new rectangle with the x values of the left and right points and Y values of the high and low points
         return new RectangleA(new Point(_temp_left.getX(),_temp_low.getY()),new Point(_temp_right.getX(),_temp_high.getY()));

    }

    /**
     * toString is a function that returns a string form of the list
     * in toString we use the help function nodeCounter in order to count how many nodes are in the list
     * space complexity O(n), because the string keeps getting bigger in relation to the list, running complexity O(n)
     * @return a string form of the list
     */
    @Override
    public String toString() {
        String s="";
        s=s+("The list has "+nodeCounter()+" rectangles.\n");
        int counter=1;
        RectNode _temp_h=_head;
        while (_temp_h!=null){
            s=s+counter+". "+_temp_h.getRect().toString()+"\n";
            _temp_h=_temp_h.getNext();
            counter=counter+1;
        }
        return s;
    }

    /**
     * nodeCounter is a help function for toString that counts the number of nodes in the list
     * space complexity O(1), running complexity O(n)
     * @return the number of nodes in the list
     */
    private int nodeCounter(){
        int counter=0;
        if (_head==null)
            return counter;
        RectNode _temp_h=_head;
        while (_temp_h!=null){
            counter=counter+1;
            _temp_h=_temp_h.getNext();
        }
        return counter;
    }
}
