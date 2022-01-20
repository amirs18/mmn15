public class RectNode {
     private RectangleA _rect;
     private  RectNode _next;

     public RectNode(RectangleA r) {
          this._rect = new RectangleA(r);
          _next=null;
     }

     public RectNode(RectangleA r, RectNode n) {
          this._rect = new RectangleA(r);
          this._next = n;
     }

     public RectNode (RectNode r){
          if (r!=null) {
               this._rect = new RectangleA(r._rect);
               this._next = r._next;
          }
     }

     public RectangleA getRect() {
          return new RectangleA(this._rect);
     }
     public RectNode getNext() {
          return new RectNode(_next);
     }

     public void setRect(RectangleA r) {
          this._rect = new RectangleA(r);
     }

     public void setNext(RectNode _next) {
          this._next = _next;
     }

     /* public RectNode (RectangleA r){
         _rect=new RectangleA(r);
         _next=null;
    }
    public RectNode (RectangleA r, RectNode n){
          _rect= new RectangleA(r);
          _next=new RectNode(n);
    }
    public RectNode (RectNode r){
          _rect=new RectangleA(r._rect);
          _next=new RectNode(r._next);
    }
    public RectangleA get_rect(){
          return this._rect;
    }
     public RectNode get_next(){
          return this._next;
     }
     public void set_rect(RectangleA r){
          this._rect=new RectangleA(r);
     }

     */
}
