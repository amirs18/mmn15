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
        if (_temp_h==null) {
            _temp_h = new RectNode(r);
            return;
        }
            while (_temp_h.getNext()!=null){
            if (_temp_h.getRect().equals(r))
                return;
            _temp_h=_temp_h.getNext();
        }
        _temp_h.setNext(new RectNode(r));
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
                counter++;
            _temp_h=_temp_h.getNext();
        }
        return counter;
    }
}
