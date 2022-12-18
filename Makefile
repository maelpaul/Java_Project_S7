all: source test recette utest clean

source:

	javac -d build src/*.java

test: source

	javac -d build -cp build tst/*.java


recette: source test 
	java -cp build -ea Simple
	java -cp build -ea Complex
	java -cp build -ea SimpleCollecteAUn
	java -cp build -ea SimpleCollecteEstUn

recette-a-un: source test 
	java -cp build -ea SimpleCollecteAUn

recette-est-un: source test 
	java -cp build -ea SimpleCollecteEstUn

utest: source test

	java -cp build -ea tec.TestPosition
	java -cp build -ea tec.TestJauge
	java -cp build -ea tec.TestAutobus
	java -cp build -ea tec.TestArretAgoraphobe
	java -cp build -ea tec.TestArretCalme
	java -cp build -ea tec.TestArretNerveux
	java -cp build -ea tec.TestArretPoli
	java -cp build -ea tec.TestArretPrudent
	java -cp build -ea tec.TestMonteeFatigue
	java -cp build -ea tec.TestMonteeRepos
	java -cp build -ea tec.TestMonteeSportif
	java -cp build -ea tec.TestMonteeTetu

autotest: source utest
	java -cp build -ea tec.LancerTest tec.TestPosition
	java -cp build -ea tec.LancerTest tec.TestJauge
	java -cp build -ea tec.LancerTest tec.TestAutobus
	java -cp build -ea tec.LancerTest tec.TestArretAgoraphobe
	java -cp build -ea tec.LancerTest tec.TestArretCalme
	java -cp build -ea tec.LancerTest tec.TestArretNerveux
	java -cp build -ea tec.LancerTest tec.TestArretPoli
	java -cp build -ea tec.LancerTest tec.TestArretPrudent
	java -cp build -ea tec.LancerTest tec.TestMonteeFatigue
	java -cp build -ea tec.LancerTest tec.TestMonteeRepos
	java -cp build -ea tec.LancerTest tec.TestMonteeSportif
	java -cp build -ea tec.LancerTest tec.TestMonteeTetu

clean:

	rm -rf build/*.class

cleanall:
	rm -rf build/*.class
	rm -rf build/*.txt
	rm -rf build/*	
