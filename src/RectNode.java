public class RectNode {
     private RectangleA _rect;
     private  RectNode _next;

     /**
      * first constructor, creates a RectNode with a given rectangle and no next RectNode value
      * @param r the given rectangle
      */
     public RectNode(RectangleA r) {
          this._rect = new RectangleA(r);
          _next=null;
     }

     /**
      * second constructor, creates a RectNode with a given rectangle and a given next RectNode value
      * @param r the given rectangle
      * @param n the given RectNode
      */
     public RectNode(RectangleA r, RectNode n) {
          this._rect = new RectangleA(r);
          this._next = n;
     }

     /**
      * third constructor, copy constructor creates a RectNode with a given RectNode value
      * @param r the given RectNode value
      */
     public RectNode (RectNode r){
          if (r!=null) {
               this._rect = new RectangleA(r._rect);
               this._next = r._next;
          }
     }

     /**
      * the function getRect returns the RectangleA value of the RectNode
      * space complexity O(1), running complexity O(1)
      * @return the RectangleA value of the RectNode
      */
     public RectangleA getRect() {
          if (this!=null)
          return new RectangleA(this._rect);
          return null;
     }

     /**
      * the function getNext returns the Next RectNode value of RectNode
      * space complexity O(1), running complexity O(1)
      * @return the Next RectNode value of RectNode
      */
     public RectNode getNext() {
          if (this!=null)
          return _next;
          return null;
     }

     /**
      * the function setRect sets the value of the RectangleA to a given RectangleA
      * space complexity O(1), running complexity O(1)
      * @param r the given RectangleA
      */
     public void setRect(RectangleA r) {
          this._rect = new RectangleA(r);
     }

     /**
      *  the function setNext sets the value of the next RectNode to a given RectNode
      *  space complexity O(1), running complexity O(1)
      * @param _next the given setNext
      */
     public void setNext(RectNode _next) {
          this._next = _next;
     }
}
