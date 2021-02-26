import React from 'react';
import SearchBar from '../SearchBar/SearchBar';
import styles from './HomePage.module.css';
import BookCard from '../BookCard/BookCard';

const HomePage = (props) => {
    return (
        <div className={styles.main_wrapper}>
           <div>
           <h1>Book Store</h1>
                <SearchBar 
                    inputValueHandler={props.inputValueHandler}
                    searchOnPressingEnter={props.searchOnPressingEnter}
                    onClick={props.onClick}
                    btnName={props.btnName}
                />
                <main className={styles.book_card_wrapper}>
                    <BookCard 
                        bookTitleHandler={props.bookTitleHandler}
                        emptyDescription={props.emptyDescription}
                        cardCounterHandler={props.cardCounterHandler}
                        googleBookLinkHandler={props.googleBookLinkHandler}
                        descriptionHandler={props.descriptionHandler}
                        showModelOnInfoClick={props.showModelOnInfoClick}
                        bookSearchHandler={props.inputValue}
                        inputValue={props.inputValueHandler}
                        printType={props.printType}
                        sortBy={props.sortBy}
                        keyword={props.keyword}
                        startItemIndex={props.startItemIndex}
                        maxItems={props.maxItems}
                    />
                </main>
           </div>
        </div>
    )
}

export default HomePage;