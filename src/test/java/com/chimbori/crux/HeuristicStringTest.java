package com.chimbori.crux;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class HeuristicStringTest {
  @Test
  public void testOriginalStringIsRetained() {
    try {
      new HeuristicString("original").or("changed");
    } catch (HeuristicString.CandidateFound candidateFound) {
      assertEquals("original", candidateFound.candidate);
    }
  }

  @Test
  public void testChangedStringIsSetIfOriginalIsNull() {
    try {
      new HeuristicString(null).or("changed");
    } catch (HeuristicString.CandidateFound candidateFound) {
      assertEquals("changed", candidateFound.candidate);
    }
  }

  @Test
  public void testChangedStringIsSetIfOriginalIsEmpty() {
    try {
      new HeuristicString("").or("changed");
    } catch (HeuristicString.CandidateFound candidateFound) {
      assertEquals("changed", candidateFound.candidate);
    }
  }

  @Test
  public void testOriginalStringIsRetainedIfChangedStringIsNull() {
    try {
      new HeuristicString("original").or(null);
    } catch (HeuristicString.CandidateFound candidateFound) {
      assertEquals("original", candidateFound.candidate);
    }
  }

  @Test
  public void testOriginalStringIsRetainedIfChangedStringIsEmpty() {
    try {
      new HeuristicString("original").or("");
    } catch (HeuristicString.CandidateFound candidateFound) {
      assertEquals("original", candidateFound.candidate);
    }
  }

  @Test
  public void testNullOriginalStringIsPreservedIfAllChangedStringsAreNull() {
    try {
      assertNull(new HeuristicString(null).or(null).toString());
    } catch (HeuristicString.CandidateFound candidateFound) {
      assertEquals(null, candidateFound.candidate);
    }
  }
}
