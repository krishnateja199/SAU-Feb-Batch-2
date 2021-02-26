import React, { Component } from 'react';
import './BaseCSS/reset.css';
import './App.css';
import Backdrop from './Components/Backdrop/Backdrop';
import HomePage from './Components/HomePage/HomePage';
import { BrowserRouter as Router, Route, Redirect } from 'react-router-dom';


class App extends Component {
  state = {
    keyword: '',
    currentKeyword: '',
    sort: 'relevance',
    print: 'all',
    modelToggle: 'none',
    description: [],
    currentDescription: '',
    googleBookLinks: [],
    currentLink: '',
    bookTitle: [],
    currentTitle: '',
    startItemIndex: 0,
    maxItems: 8,
  
   }
inputValueHandler = (value) => {
    this.setState({ currentKeyword: value })
  }
  bookSearchHandler = () => {
    this.setState({ keyword: this.state.currentKeyword })
  }
  searchOnPressingEnter = (event) => {
    if (event.keyCode === 13) {
      this.bookSearchHandler()
    }
  }

  // Displays the model on clicking info button and filters and store the description of clicked info
  showModelOnInfoClick = (index) => {
    this.setState({ modelToggle: 'flex' })
    this.descriptionHandler()

    // Filters the description and google book link of clicked info
    let currDec = this.state.description.filter((el, i) => {
      return i === index
    }
    )
    let currLink = this.state.googleBookLinks.filter((el, i) => {
      return i === index
    }
    )
    let currTitle = this.state.bookTitle.filter((el, i) => {
      return i === index
    })
    this.setState({ currentDescription: currDec, currentLink: currLink, currentTitle: currTitle })
  }

  hideModelWindow = () => {
    this.setState({ modelToggle: 'none' })
  }

  //Handles the description, link and title for model window
  descriptionHandler = (desc) => {
    let description = [...this.state.description]
    description.push(desc)
    this.setState({ description: description })
  }
  googleBookLinkHandler = (link) => {
    let links = [...this.state.googleBookLinks]
    links.push(link)
    this.setState({ googleBookLinks: links })
  }
  bookTitleHandler = (title) => {
    let bookTitle = [...this.state.bookTitle]
    bookTitle.push(title)
    this.setState({ bookTitle: bookTitle })
  }
  //Resets the description and google book link to empty when any thing changes in state 
  emptyDescription = () => {
    this.setState({ description: [], googleBookLinks: [], bookTitle: [], disabledStatus: false })
  }

  
  render() {
    return (
      <Router>
              <Redirect to='/' />
                <Backdrop
                  bookTitle={this.state.currentTitle[0]}
                  infoLink={this.state.currentLink[0]}
                  description={this.state.currentDescription}
                  modelToggle={this.state.modelToggle}
                  hideModel={this.hideModelWindow} />
                <HomePage
                  inputValueHandler={this.inputValueHandler}
                  searchOnPressingEnter={this.searchOnPressingEnter}
                  onClick={this.bookSearchHandler}
                  btnName='Search'
                  bookTitleHandler={this.bookTitleHandler}
                  emptyDescription={this.emptyDescription}
                  cardCounterHandler={this.cardCounterHandler}
                  googleBookLinkHandler={this.googleBookLinkHandler}
                  descriptionHandler={this.descriptionHandler}
                  showModelOnInfoClick={this.showModelOnInfoClick}
                  bookSearchHandler={this.bookSearchHandler}
                  inputValue={this.inputValueHandler}

                  //To print the info in cards
                  printType={this.state.print}
                  sortBy={this.state.sort}
                  keyword={this.state.keyword}
                  startItemIndex={this.state.startItemIndex}
                  maxItems={this.state.maxItems}
                />
                <Route path="/" exact component={this.Home} />
          
      </Router>
    );
  }
}

export default App;
