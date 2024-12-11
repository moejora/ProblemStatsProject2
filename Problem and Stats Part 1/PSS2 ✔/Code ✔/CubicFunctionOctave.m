function retval = PSS2_Plotter(in1, in2)

  %Parameters for the cubic function ax^3 + bx^2 + cx + d
  a = 1;
  b = -2;
  c = 3;
  d = 5;

  %Generate the Salt Data
  x = -50:1:50;

  %New Function for ax^3 + bx^2 + cx + d
  y = a * x.^3 + b * x.^2 + c * x + d;

  rng(50);
  salter = rand(size(y)) * 2 - 1;
  ySalt = y + salter;

  %Plot the Combined Data
  figure;
  plot(x, y, 'b-', 'LineWidth', 1);
  hold on;
  plot(x, ySalt, 'r.', 'MarkerSize', 10);
  title('Combined Data');
  xlabel('X');
  ylabel('Y');
  legend('Equation Data', 'Salt Data');
  grid on;

  %Window Size Edits
  if nargin < 2
    windowSize = 5;
  else
    windowSize = in2;
  end
  ySmooth = movmean(ySalt, windowSize);

  %Plotting the Smoothed Data
  figure;
  grid on;
  plot(x, ySalt, 'r.', 'MarkerSize', 10);
  hold on;
  plot(x, ySmooth, 'g-', 'LineWidth', 1);
  title('Salted & Smoothed Data');
  xlabel('X');
  ylabel('Y');
  legend('Salted Data', 'Smoothed Data');

  %Data to CSV
  out = [x', ySalt', ySmooth'];
  csvwrite('smoothdata.csv', out);
  display('CSV Exported.');

  %Output the Data
  retval = out;
endfunction
