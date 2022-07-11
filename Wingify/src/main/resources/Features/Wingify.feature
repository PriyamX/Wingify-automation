Feature: Wingify automation test case 

   @WingifyHeatmap
   Scenario: Verify email button on heatmap page gets highlighted
   Given user launches browser
   When user navigates to vwo heatmap page
   And user clicks on view heatmap button ##validate new window is opened
   And user clicks on element list tab ##verify element list panel is opened and displayed
   And user clicks on email button on element list 
   Then email button gets highlighted on the page
   
    
  