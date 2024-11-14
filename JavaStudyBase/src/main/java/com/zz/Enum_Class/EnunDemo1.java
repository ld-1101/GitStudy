package com.zz.Enum_Class;

import org.junit.Test;

/**
 * @description: 枚举类
 * @author zz
 * @create 2024-11-14   上午9:06
 * 定义枚举类
 * 使用enum定义枚举类，枚举类中只能定义常量，不能定义方法和属性。
 * 枚举类中可以定义构造方法，但是构造方法不能有参数。
 * 枚举类中可以定义方法，属性等。
 *
 */
public class EnunDemo1 {
    public static void main(String[] args) {
        ColorEnum color = ColorEnum.valueOf("RED");
        System.out.println(color);
        for (ColorEnum c : ColorEnum.values()) {
            System.out.println(c.name() + ":" + c.getName() + ":" + c.getCode());
        }

    }
    @Test
    public void test() {
        Color color = Color.Pink;
        System.out.println(color);
        System.out.println(color.getCode());
        System.out.println(color.getDesc());
    }
    @Test
    public void test1() {
        ColorEnum colorEnum = ColorEnum.RED;
        System.out.println(colorEnum.getDesc());
        }
        @Test
        public void test2() {
           for (ColorEnum colorEnum : ColorEnum.values()) {
               System.out.println(colorEnum.getDesc());
           }
        }

}





    class Color implements EnumInterface {
        private String name;
        private String code;

        public Color(String name, String code) {
            this.name = name;
            this.code = code;
        }
         static final Color Yellow = new Color("黄色","987654"){
            @Override
            public String getDesc() {
                return "黄色是一个让人开心的颜色";
            }
         };
         static final Color Pink = new Color("粉色","123456");
         static final Color Black = new Color("黑色","654321"){
             @Override
             public String getDesc() {
                 return "黑色是一个让人心寒的颜色";
             }
         };
         static final Color White = new Color("白色","563412");
        public String getName() {
            return name;
        }

        public String getCode() {
            return code;
        }


        @Override
        public String getDesc() {
            return name + "是一个让人高兴的颜色";
        }

        @Override
        public String toString() {
            return "Color{" +
                    "name='" + name + '\'' +
                    ", code='" + code + '\'' +
                    '}';

        }
    }


    enum ColorEnum implements EnumInterface {
        RED("红色","123456"){
            @Override
            public String getDesc() {
                return "红色是一个让人生气的颜色";
            }
        },
        GREEN("绿色","654321"){
            @Override
            public String getDesc() {
                return "绿色是一个让人开心的颜色";
            }
        },
        BLUE("蓝色","563412"){
            @Override
            public String getDesc() {
                return "蓝色是一个让人心情愉悦的颜色";
            }
        };

        private String name;
        private String code;

        ColorEnum(String name, String code) {
            this.name = name;
            this.code = code;
        }

        public String getName() {
            return name;
        }

        public String getCode() {
            return code;
        }

        @Override
        public String toString() {
            return "ColorEnum{" +
                    "name='" + name + '\'' +
                    ", code='" + code + '\'' +
                    '}';
        }
    }
