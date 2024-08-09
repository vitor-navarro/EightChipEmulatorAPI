package com.example.EightChipEmulatorAPI.entity;

import java.math.BigInteger;
import java.util.List;

public class ScoreEntity {
    BigInteger score;
    //UserEntity player; //Deveria colocar? Vou ver na modelagem
    List<BigInteger> previousScores;
    String game; //mudar posteriormente
}
