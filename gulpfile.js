var gulp = require('gulp');
var concat = require('gulp-concat');
var es = require('event-stream');
var sass = require('gulp-sass');
var clean = require('gulp-clean');

gulp.task('clean', function () {
    gulp.src('dist')
        .pipe(clean());
});
gulp.task('sass', function () {
    return es.merge([
        gulp.src([
            'node_modules/bootstrap/dist/css/bootstrap.min.css'
        ]),
        gulp.src('src/scss/**/*.scss')
            .pipe(sass()).on('error', sass.logError)
    ])
        .pipe(concat('style.css'))
        .pipe(gulp.dest('dist'));
});


gulp.task('js',function () {
    return es.merge([gulp.src([
        'node_modules/angular/angular.min.js',
        'node_modules/angular-route/angular-route.min.js',
        'node_modules/jquery/dist/jquery.min.js',
        'node_modules/bootstrap/dist/js/bootstrap.min.js'

    ]),
        gulp.src('src/js/**/*.js')
    ]).pipe(concat('script.js'))
        .pipe(gulp.dest('dist'));
});


gulp.task('html', function () {
    return es.merge([
        gulp.src('src/*.html')
            .pipe(gulp.dest('dist')),
        gulp.src('src/templates/*')
            .pipe(gulp.dest('dist/templates'))
    ]);
});

gulp.watch('src/scss/**/*.scss', ['sass']);
gulp.watch('src/**/*.html', ['html']);
gulp.watch('src/js/**/*.js', ['js']);

gulp.task('default', ['js', 'html', 'sass']);