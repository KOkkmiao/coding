package coding;

import io.protostuff.Exclude;
import io.protostuff.Tag;
import io.protostuff.runtime.DefaultIdStrategy;
import io.protostuff.runtime.RuntimeSchema;

import javax.swing.*;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author xpmiao
 * @date 2023/8/8
 */
public class TestProtostuff {
    static class EntityFather{
        @Tag(44)
        String ff;
        public String getFf() {
            return ff;
        }
        public void setFf(String ff) {
            this.ff = ff;
        }
    }
    static class Entity extends EntityFather{
        @Tag(1)
        String aa ;
        @Tag(2)
        @Exclude
        transient String bb ;
        // @Tag(4)
        // @Deprecated
        // String ff;
        @Tag(3)
        String cc ;
        public String getAa() {
            return aa;
        }
        public void setAa(String aa) {
            this.aa = aa;
        }
        public String getBb() {
            return bb;
        }
        public void setBb(String bb) {
            this.bb = bb;
        }
        public String getCc() {
            return cc;
        }
        public void setCc(String cc) {
            this.cc = cc;
        }
        // public String getFf() {
        //     return ff;
        // }
        // public void setFf(String ff) {
        //     this.ff = ff;
        // }
        @Override
        public String toString() {
            return "Entity{" +
                    "aa='" + aa + '\'' +
                    ", bb='" + bb + '\'' +
                    ", ff='" + ff + '\'' +
                    ", cc='" + cc + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) {



        Entity deserialize =
                (Entity) ProtostuffUtil.deserializeProtoStuffDataListToProductsObject(("\n"
                        + "\u00011\u001A\u00013\"\u00014").getBytes(),Entity.class);
        System.out.println(deserialize);

        // deserialize =
        //         (Entity) protobufSerializer.deserialize(protobufSerializer.serialize(entity));
        // System.out.println(deserialize);
    }
}
