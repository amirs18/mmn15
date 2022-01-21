public class RectList {
    private  RectNode _head ;

    public RectList() {
        this._head=null;
    }

   /* public RectList(RectNode _head) {
        this._head = _head;
    }

    */

    /**
     *
     * @param r
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
     *
     * @param p
     * @return
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
    public RectangleA minimalContainer(){
        if (_head==null)
            return null;
        return new RectangleA(new Point(mostLeftRect().getX(),lowestRect().getY()),new Point(mostRightRect().getX(),highestRect().getY()));
    }
    private Point mostRightRect(){
        if (_head==null)
            return null;
        Point _temp_p=_head.getRect().getPointNE();
        RectNode _temp_h=_head;
        while (_temp_h!=null){
            if (_temp_h.getRect().getPointNE().isRight(_temp_p))
                _temp_p= _temp_h.getRect().getPointNE();
            _temp_h=_temp_h.getNext();
        }
        return new Point(_temp_p);
    }
    private Point lowestRect(){
        if (_head==null)
            return null;
        Point _temp_p=_head.getRect().getPointSW();
        RectNode _temp_h=_head;
        while (_temp_h!=null){
            if (_temp_h.getRect().getPointSW().isUnder(_temp_p))
                _temp_p= _temp_h.getRect().getPointSW();
            _temp_h=_temp_h.getNext();
        }
        return new Point(_temp_p);
    }

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
